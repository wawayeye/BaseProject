package com.tuandai.baseproject.enums;

/**
 * 错误码定义
 *
 * @author hujunfei
 * @date 2018-11-23 16:38
 */
public enum MsgCodeEnum {
    /**
     * 错误码枚举
     */
    CALL_ERROR(-3, "服务调用失败"),
    SERVER_ERROR(-2, "服务异常，请稍后重试"),
    FAILURE(-1, "请求失败"),
    SUCCESS(1, "请求成功"),
    INVALID_PARAM(1000, "参数错误"),
    DATA_STORE_ERROR(500, "数据存储失败");

    private final int code;

    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MsgCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
