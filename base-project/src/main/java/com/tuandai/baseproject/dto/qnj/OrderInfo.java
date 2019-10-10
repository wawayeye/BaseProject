package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 订单信息
 *
 * @author hujunfei
 * @date 2018-11-30 15:07
 */
public class OrderInfo {

    /**
     * 订单唯一编号
     */
    @JsonProperty("order_sn")
    private String orderSn;

    /**
     * 借款金额（单位：分）
     */
    @JsonProperty("loan_amount")
    private String loanAmount;

    /**
     * 借款期限
     */
    @JsonProperty("loan_term")
    private String loanTerm;

    /**
     * 期限类型（1：按天  2：按月  3：按年）
     */
    @JsonProperty("term_type")
    private String termType;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderSn='" + orderSn + '\'' +
                ", loanAmount='" + loanAmount + '\'' +
                ", loanTerm='" + loanTerm + '\'' +
                ", termType='" + termType + '\'' +
                '}';
    }
}
