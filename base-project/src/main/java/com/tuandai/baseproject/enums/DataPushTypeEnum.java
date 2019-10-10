package com.tuandai.baseproject.enums;

/**
 * 推送类型    1 用户过滤   2 一推
 *
 * @author hujunfei
 * @date 2018-12-17 14:40
 */
public enum DataPushTypeEnum {
    /**
     * 推送类型枚举
     */
    USER_FILTER(1, "用户过滤"),
    FIRST_PUSH(2, "一推数据");

    private final int code;

    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    DataPushTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
