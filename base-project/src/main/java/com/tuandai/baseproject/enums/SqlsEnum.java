package com.tuandai.baseproject.enums;

/**
 * sql定义
 *
 * @author xiaoyong
 * @date 2019-03-21 15:01
 */
public enum SqlsEnum {
    FindApplyAduitDataLogSql("select order_sn,record_version,report_json,type,crawler_from from dw_ods.s123_t_user_push_logs", "获取原始数据一推二推数据"),
    FindUserRecentPushLogSql("select status,txn_id from dw_ods.s123_t_user_push_logs", "获取用户最近的一条推送记录"),
    FindUserChannelInfoSql("select user_id,txn_id from dw_ods.s123_t_channel_platform_relation", "获取用户user_id"),
    UpdateAuditDataLogSql("", "一推二推原始数据修改状态为成功");

    private final String sql;

    private final String msg;

    public String getSql() {
        return sql;
    }

    public String getMsg() {
        return msg;
    }

    SqlsEnum(String sql, String msg) {

        this.sql = sql;
        this.msg = msg;
    }

}
