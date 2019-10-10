package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 本地通话记录
 *
 * @author hujunfei
 * @date 2018-12-13 10:59
 */
public class LocalContact {

    /**
     * 手机号
     */
    @JsonProperty("phone_num")
    private String phoneNum;

    /**
     * 日期
     */
    private String date;

    /**
     * 时长
     */
    private String duration;

    /**
     * 呼叫类型 (打入,打出,未接)
     */
    @JsonProperty("call_type")
    private String callType;

    /**
     * 抓取时间
     */
    @JsonProperty("obtain_time")
    private String obtainTime;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(String obtainTime) {
        this.obtainTime = obtainTime;
    }

    @Override
    public String toString() {
        return "LocalContact{" +
                "phoneNum='" + phoneNum + '\'' +
                ", date='" + date + '\'' +
                ", duration='" + duration + '\'' +
                ", callType='" + callType + '\'' +
                ", obtainTime='" + obtainTime + '\'' +
                '}';
    }
}
