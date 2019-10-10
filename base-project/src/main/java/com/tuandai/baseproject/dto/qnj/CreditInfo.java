package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 信用信息
 *
 * @author hujunfei
 * @date 2018-12-01 14:57
 */
public class CreditInfo {

    /**
     * 信用状态：1.信用良好，2.无信用卡或贷款，3.少量逾期，4.信用较差
     */
    @JsonProperty("credit_status")
    private String creditStatus;

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    @Override
    public String toString() {
        return "CreditInfo{" +
                "creditStatus='" + creditStatus + '\'' +
                '}';
    }
}
