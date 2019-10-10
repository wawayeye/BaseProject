package com.tuandai.baseproject.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.tuandai.baseproject.dto.qnj.req.ChannelPlatformReq;
import com.tuandai.baseproject.dto.qnj.resp.ChannelPlatformRelationDTO;
import com.tuandai.baseproject.enums.ChannelInfoEnum;
import com.tuandai.baseproject.enums.SqlsEnum;
import com.tuandai.baseproject.service.UserService;
import com.tuandai.baseproject.util.BuildSqlUtils;
import com.tuandai.baseproject.util.ImpalaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 获取用户user_id
     * @param orderSn
     * @return
     */
    @Override
    public String getUserByOrderSn(String orderSn) {
        if (StringUtils.isEmpty(orderSn)) {
            return "";
        }
        ChannelPlatformReq req = new ChannelPlatformReq();
        req.setTxn_id(orderSn);
        req.setPlatform(ChannelInfoEnum.QNJ.getCode());
        List<ChannelPlatformRelationDTO> relationDTOS = null;
        String sql = BuildSqlUtils.SqlsEnumBuild(SqlsEnum.FindUserChannelInfoSql.getSql(),req);
        try {
            relationDTOS = ImpalaUtils.executeQuery(ChannelPlatformRelationDTO.class, sql);
        } catch (Exception e) {
            logger.error("查询推送记录失败"+SqlsEnum.FindUserChannelInfoSql.getSql()+"，返回信息：{}", e);
        }
        // 如果查询不到，返回空
        if (CollectionUtils.isEmpty(relationDTOS)) {
            return "";
        }
        return relationDTOS.get(0).getUser_id();
    }
}
