package com.tuandai.baseproject.model;

public class CallRecordStat {
    private String user_id;
    private String open_time;
    private String double_call;
    private String name;
    private String idcard;
    private String phone;
    private String valid_phone_sum;
    private String valid_call_sum;
    private String vaild_phone_sum;
    private String vaild_call_sum;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getDouble_call() {
        return double_call;
    }

    public void setDouble_call(String double_call) {
        this.double_call = double_call;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValid_phone_sum() {
        return valid_phone_sum;
    }

    public void setValid_phone_sum(String valid_phone_sum) {
        this.valid_phone_sum = valid_phone_sum;
    }

    public String getValid_call_sum() {
        return valid_call_sum;
    }

    public void setValid_call_sum(String valid_call_sum) {
        this.valid_call_sum = valid_call_sum;
    }

    public String getVaild_phone_sum() {
        return vaild_phone_sum;
    }

    public void setVaild_phone_sum(String vaild_phone_sum) {
        this.vaild_phone_sum = vaild_phone_sum;
    }

    public String getVaild_call_sum() {
        return vaild_call_sum;
    }

    public void setVaild_call_sum(String vaild_call_sum) {
        this.vaild_call_sum = vaild_call_sum;
    }

    @Override
    public String toString() {
        return "CallRecordStat{" +
                "user_id='" + user_id + '\'' +
                ", open_time='" + open_time + '\'' +
                ", double_call='" + double_call + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", valid_phone_sum='" + valid_phone_sum + '\'' +
                ", valid_call_sum='" + valid_call_sum + '\'' +
                ", vaild_phone_sum='" + vaild_phone_sum + '\'' +
                ", vaild_call_sum='" + vaild_call_sum + '\'' +
                '}';
    }
}
