package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 通讯录
 *
 * @author hujunfei
 * @date 2018-11-30 17:50
 */
public class AddressBook {

    /**
     * 通讯录列表 name_phone
     */
    @JsonProperty("phone_list")
    private List<String> phoneList;

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "phoneList=" + phoneList +
                '}';
    }
}
