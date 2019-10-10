package com.tuandai.baseproject.enums;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ApplyAduitDataTypeEnum {
    /*
       1.社保信息 2.信用卡邮箱信息 3.运营商 4.征信
    */
    SECURETY(1, "社保信息"),
    CREDIT(2, "信用卡邮箱信息"),
    YUN_XING_SHANG(3, "运营商"),
    ZHENG_XING(4, "征信"),
    MOBILE_INFO(5, "手机指纹"),
    USER_INFO(6, "个人信息"),
    ASSET_USER_INFO(7, "资产端资产信息"),
    MOBILE_CONTACT(8, "手机通讯录"),
    APPLY_CREDIT_AMOUNT(9, "申请授信额度报文"),
    APPLY_BORROW_AUDIT(10, "申请借款申请报文"),
    CALL_HISTORY(11, "通话记录"),
    APP_LIST(12, "app列表"),
    CONTROL_MODEL_RESULT(13, "风控模型结果"),
    USER_ADDITIONAL_INFO(14, "二推原数据"),
    USER_COMMON_INFO(15, "一推原数据"),
    MOBILE_REPORT_INFO(16, "手机报告"),
    MOBILE_GPS(17, "gps"),
    MOBILE_SMS(18, "短信记录");

    private int type;
    private String message;

    ApplyAduitDataTypeEnum(int type, String message) {
        this.type = type;
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	private static final ConcurrentMap<Integer, ApplyAduitDataTypeEnum> typeNames = new ConcurrentHashMap<Integer, ApplyAduitDataTypeEnum>();

	static {
		for (ApplyAduitDataTypeEnum type : values()) {
			typeNames.put(type.getType(), type);
		}
	}
	public static ApplyAduitDataTypeEnum get(final int code) {
		return typeNames.get(code);
	}
}
