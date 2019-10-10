package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 其他网贷平台总借款金额
 *
 * @author hujunfei
 * @date 2018-12-03 11:58
 */
public class OtherLoanAmount {

    /**
     * 其他网贷平台总借款金额
     */
    @JsonProperty("other_loan_amount")
    private String otherLoanAmount;

    public String getOtherLoanAmount() {
        return otherLoanAmount;
    }

    public void setOtherLoanAmount(String otherLoanAmount) {
        this.otherLoanAmount = otherLoanAmount;
    }

    @Override
    public String toString() {
        return "OtherLoanAmount{" +
                "otherLoanAmount='" + otherLoanAmount + '\'' +
                '}';
    }
}
