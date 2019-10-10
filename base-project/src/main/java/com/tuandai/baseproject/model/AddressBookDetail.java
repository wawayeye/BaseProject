package com.tuandai.baseproject.model;

public class AddressBookDetail {
    private String user_id;
    private String phone;
    private String is_valid;
    private String name;
    private String is_emg;
    private String sensitivity;
    private String contactIn6months;
    private String contactin6months;

    public String getContactin6months() {
        return contactin6months;
    }

    public void setContactin6months(String contactin6months) {
        this.contactin6months = contactin6months;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_emg() {
        return is_emg;
    }

    public void setIs_emg(String is_emg) {
        this.is_emg = is_emg;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public String getContactIn6months() {
        return contactIn6months;
    }

    public void setContactIn6months(String contactIn6months) {
        this.contactIn6months = contactIn6months;
    }

    @Override
    public String toString() {
        return "AddressBookDetail{" +
                "user_id='" + user_id + '\'' +
                ", phone='" + phone + '\'' +
                ", is_valid='" + is_valid + '\'' +
                ", name='" + name + '\'' +
                ", is_emg='" + is_emg + '\'' +
                ", sensitivity='" + sensitivity + '\'' +
                ", contactIn6months='" + contactIn6months + '\'' +
                '}';
    }
}
