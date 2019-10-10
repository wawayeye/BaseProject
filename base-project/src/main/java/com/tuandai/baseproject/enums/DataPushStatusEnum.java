package com.tuandai.baseproject.enums;

/**
 * 数据推送状态
 *
 * @author hujunfei
 * @date 2018-12-17 14:43
 */
public enum DataPushStatusEnum {
    /**
     * 数据推送状态
     */
    PASS(1, "通过"),
    FAILED(2, "失败");

    private final int code;

    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    DataPushStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
