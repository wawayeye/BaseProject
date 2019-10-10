package com.tuandai.baseproject.model;

public class CallRecordDetail {
    private String user_id;
    private String name;
    private String phone;
    private String call_location;
    private String home_location;
    private String totail_call;
    private String dial;
    private String dialed;
    private String totail_time;
    private String first_time;
    private String last_time;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCall_location() {
        return call_location;
    }

    public void setCall_location(String call_location) {
        this.call_location = call_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHome_location() {
        return home_location;
    }

    public void setHome_location(String home_location) {
        this.home_location = home_location;
    }

    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    public String getDialed() {
        return dialed;
    }

    public void setDialed(String dialed) {
        this.dialed = dialed;
    }

    public String getTotail_call() {
        return totail_call;
    }

    public void setTotail_call(String totail_call) {
        this.totail_call = totail_call;
    }

    public String getTotail_time() {
        return totail_time;
    }

    public void setTotail_time(String totail_time) {
        this.totail_time = totail_time;
    }

    public String getFirst_time() {
        return first_time;
    }

    public void setFirst_time(String first_time) {
        this.first_time = first_time;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    @Override
    public String toString() {
        return "CallRecordDetail{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", call_location='" + call_location + '\'' +
                ", home_location='" + home_location + '\'' +
                ", totail_call='" + totail_call + '\'' +
                ", dial='" + dial + '\'' +
                ", dialed='" + dialed + '\'' +
                ", totail_time='" + totail_time + '\'' +
                ", first_time='" + first_time + '\'' +
                ", last_time='" + last_time + '\'' +
                '}';
    }
}
