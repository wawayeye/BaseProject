package com.tuandai.baseproject.model;

public class AddressBookStat {
    private String user_id;
    private String sum;
    private String abnormal_sum;
    private String call_sum;
    private String updateTime;
    private String updatetime;
    private String device;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getAbnormal_sum() {
        return abnormal_sum;
    }

    public void setAbnormal_sum(String abnormal_sum) {
        this.abnormal_sum = abnormal_sum;
    }

    public String getCall_sum() {
        return call_sum;
    }

    public void setCall_sum(String call_sum) {
        this.call_sum = call_sum;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "AddressBookStat{" +
                "user_id='" + user_id + '\'' +
                ", sum='" + sum + '\'' +
                ", abnormal_sum='" + abnormal_sum + '\'' +
                ", call_sum='" + call_sum + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}
