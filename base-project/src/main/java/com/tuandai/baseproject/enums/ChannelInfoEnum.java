package com.tuandai.baseproject.enums;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ChannelInfoEnum {

	TDW(1, "团贷网"),
	QNJ(2, "去哪借"),
	R360(3, "融360"),
	K360(4, "360导航"),
	YMT(5, "银码头")
	;

	private int code;
	private String message;

	ChannelInfoEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChannelInfoEnum=[code:+" + code + "  message:" + message + "]";
	}

	public static String getDesc(Integer code) {
		if (code == null)
			return null;
		ChannelInfoEnum[] platFormEnums = values();
		for (ChannelInfoEnum platfromEnum : platFormEnums) {
			if (platfromEnum.getCode() == code) {
				return platfromEnum.getMessage();
			}
		}
		return null;
	}

	private static final ConcurrentMap<Integer, ChannelInfoEnum> typeNames = new ConcurrentHashMap<Integer, ChannelInfoEnum>();

	static {
		for (ChannelInfoEnum code : values()) {
			typeNames.put(code.getCode(), code);
		}
	}

	public static ChannelInfoEnum get(final int code) {
		return typeNames.get(code);
	}
}
