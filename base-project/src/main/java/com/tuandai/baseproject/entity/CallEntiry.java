package com.tuandai.baseproject.entity;

public class CallEntiry {
    private String userId;
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "CallEntiry{" +
                "userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
