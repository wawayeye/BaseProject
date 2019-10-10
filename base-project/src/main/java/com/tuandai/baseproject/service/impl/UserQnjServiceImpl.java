package com.tuandai.baseproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.tuandai.baseproject.dto.ApplyAduitData;
import com.tuandai.baseproject.dto.qnj.*;
import com.tuandai.baseproject.dto.qnj.req.PushLogsReq;
import com.tuandai.baseproject.enums.*;
import com.tuandai.baseproject.service.UserQnjService;
import com.tuandai.baseproject.service.UserService;
import com.tuandai.baseproject.util.BaseRuntimeException;
import com.tuandai.baseproject.util.BuildSqlUtils;
import com.tuandai.baseproject.util.ImpalaUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service("userQnjService")
public class UserQnjServiceImpl implements UserQnjService {
    private static final Logger logger = LoggerFactory.getLogger(UserQnjServiceImpl.class);
    @Autowired
    private UserService userService;

    @Override
    public void handleUserAdditionalInfo(JSONObject record) {
        if (Objects.isNull(record)) {
            throw new BaseRuntimeException("数据为空");
        }
        String version = record.getString("recordVersion");
        String orderSn = record.getString("orderSn");
        // 先查询t_user_push_logs表中数据, 若一推数据不成功，即用户手机号或身份证号已被使用了，则直接更新状态
        UserPushLogDTO pushLogDTO = getUserRecentPushLog(orderSn);

        // 是否通过 （1、通过； 2、失败）
        if (Objects.nonNull(pushLogDTO) && pushLogDTO.getStatus() == DataPushStatusEnum.FAILED.getCode()) {
            logger.info("orderSn: {}, 查询得出用户为历史用户", orderSn);
           /* TODO xiaoyong: update mongodb 暂时不修改库状态，后期看需求统一咨询修改哪些字段
             updateAuditDataLog(record);*/
            return;
        }
        // 根据orderSn查询用户ID
        String userId = userService.getUserByOrderSn(orderSn);
        try {
            String reportJson = record.getString("reportJson");
            UserAdditional userAdditional = JSON.parseObject(reportJson, UserAdditional.class);
            logger.info("获取用户补充信息：{}", reportJson);
           /* TODO xiaoyong：update mysql 暂时不修改库状态，（binlog会自动更新），后续深圳停系统再补充数据
           // 1. 保存用户补充信息
            UserAdditionInfo additionInfo = buildUserAdditionInfo(userAdditional, userId);
            // 添加用户基本信息到MySQL表中
            logger.info("添加用户补充信息到MySQL请求: {}", JSON.toJSONString(additionInfo));
            ResponseDTO response = userClient.addUserAdditionalInfo(additionInfo);
            logger.info("添加用户补充信息到MySQL返回：{}", JSON.toJSONString(response));
            if (!response.success()) {
                logger.error("添加用户补充信息失败，{}", response.getMessage());
            } else {*/
                // 设备信息
                DeviceInfo deviceInfo = userAdditional.getDeviceInfo();
                // 发送app列表到kafka
                sendAppList(deviceInfo.getAppList(), userId,version);
                // 发送通话记录到kafka
                sendLocalContact(deviceInfo.getCallHistory(), userId,version);
                // 去掉deviceInfo中的app_list和call_history
                deviceInfo.setCallHistory(null);
                deviceInfo.setAppList(null);
                // 保存设备信息到MongoDB
                boolean saveDevice = sendDeviceInfo(deviceInfo, userId,version);
                // 保存通讯录信息到MongoDB
                boolean saveCallHistory = sendAddressBook(userAdditional.getAddressBook(), userId,version);
                if (saveCallHistory && saveDevice) {
                    // 更新kudu中的数据状态为成功
                    updateAuditDataLog(orderSn,version);
                }
           /* }*/
        } catch (Exception e) {
            logger.error("处理用户补充信息失败", e);
        }
    }
    /**
    * 更新t_apply_aduit_data_log 状态为成功
    */
    private void updateAuditDataLog(String orderSn, String version) {
        ImpalaUtils.executeQuery(SqlsEnum.UpdateAuditDataLogSql.getSql());
    }

    /**
     * 获取用户最近的一条推送记录
     * @param orderSn
     * @return
     */
    private UserPushLogDTO getUserRecentPushLog(String orderSn) {
        PushLogsReq req = new PushLogsReq();
        req.setTxn_id(orderSn);
        req.setPlatform(ChannelInfoEnum.QNJ.getCode());
        // 类型：（1、用户过滤； 2、一推）
        req.setType(DataPushTypeEnum.FIRST_PUSH.getCode());
        logger.info("查询推送记录入参：{}", req.toString());
        List<UserPushLogDTO>  userPushLogDTOS= null;
        String sql= BuildSqlUtils.SqlsEnumBuild(SqlsEnum.FindUserRecentPushLogSql.getSql(),req);
        try {
            userPushLogDTOS = ImpalaUtils.executeQuery(UserPushLogDTO.class, sql);
        } catch (Exception e) {
            logger.error("查询推送记录失败"+SqlsEnum.FindUserRecentPushLogSql.getSql()+"，返回信息：{}", e);
        }
        logger.info("查询推送记录返回值：{}", userPushLogDTOS.toString());
        return CollectionUtils.isEmpty(userPushLogDTOS) ? null : userPushLogDTOS.get(0);
    }

    /**
     * 发送用户app列表信息
     * app 列表和通话记录iOS取不到，为空
     * @param appList
     * @param userId
     * @param version
     */
    private void sendAppList(List<UserApp> appList, String userId, String version) {
        if (CollectionUtils.isEmpty(appList)) {
            logger.warn("发送用户app列表到kafka中失败，用户app列表为空");
        } else {
            sendMesBuildUserData(JSON.toJSONString(appList), userId, ApplyAduitDataTypeEnum.APP_LIST,version);
        }
    }

    /**
     * 发送用户通话记录信息
     * @param contacts
     * @param userId
     */
    private void sendLocalContact(List<LocalContact> contacts, String userId, String version) {
        if (CollectionUtils.isEmpty(contacts)) {
            logger.warn("添加用户通话记录到MongoDB中失败，用户通话记录为空");
        } else {
            sendMesBuildUserData(JSON.toJSONString(contacts), userId, ApplyAduitDataTypeEnum.CALL_HISTORY,version);
        }
    }

    /**
     * 发送设备信息到kafka
     *  @param deviceInfo
     * @param userId
     * @param version
     */
    private boolean sendDeviceInfo(DeviceInfo deviceInfo, String userId, String version) {
        boolean isSuccess = false;
        if (Objects.isNull(deviceInfo)) {
            logger.error("添加用户设备信息到MongoDB中失败，设备信息为空");
        } else {
            sendMesBuildUserData(JSON.toJSONString(deviceInfo), userId, ApplyAduitDataTypeEnum.MOBILE_INFO,version);
            isSuccess = true;
        }
        return isSuccess;
    }
    /**
     * 发送联系人信息到kafka
     *  @param addressBook
     * @param userId
     * @param version
     */
    private boolean sendAddressBook(AddressBook addressBook, String userId, String version) {
        boolean isSuccess = false;
        if (Objects.isNull(addressBook)) {
            logger.error("添加用户联系人到MongoDB中失败，联系人信息为空");
        } else {
            sendMesBuildUserData(JSON.toJSONString(addressBook), userId, ApplyAduitDataTypeEnum.MOBILE_CONTACT,version);
            isSuccess = true;
        }
        return isSuccess;
    }

    /**
     * 查询t_apply_audit_data表 ,1不存在 发kafka ，2存在 组装json ，基本信息，发送kafka
     * @param jsonStr
     * @param userId
     * @param typeEnum
     * @param version
     */
    private void sendMesBuildUserData(String jsonStr, String userId, ApplyAduitDataTypeEnum typeEnum, String version) {
        try {
            ApplyAduitData applyAduitData = new ApplyAduitData();
            Date now = new Date();
            applyAduitData.setCreateTime(now);
            applyAduitData.setRecordVersion(version);
            applyAduitData.setReportJson(jsonStr);
            applyAduitData.setSourceFrom(ChannelInfoEnum.QNJ.getCode());
            applyAduitData.setType(typeEnum.getType());
            applyAduitData.setUpdateTime(now);
            applyAduitData.setUserId(userId);
            //TODO 发送kafka qiqi
        } catch (Exception e) {
            throw new BaseRuntimeException("数据发送kafka失败，类型：" + typeEnum.getType() + ", userId: " + userId, e);
        }
    }

}
