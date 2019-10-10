package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditDataStatusInfo {
    /**
     * credit_data_status/下的状态标识
     */
    @JsonProperty("user_name")
    private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
