package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 是否提供人行征信
 *
 * @author hujunfei
 * @date 2018-12-03 11:52
 */
public class ProvideCredit {

    /**
     * 1:否 2:是
     */
    @JsonProperty("provide_credit")
    private String provideCredit;

    /**
     * 近6个月逾期账户数
     */
    @JsonProperty("overdue_account")
    private String overdueAccount;

    /**
     * 近6个月逾期笔数
     */
    @JsonProperty("overdue_order")
    private String overdueOrder;

    /**
     * 近6个月逾期总金额
     */
    @JsonProperty("overdue_total_monoy")
    private String overdueTotalMoney;

    public String getProvideCredit() {
        return provideCredit;
    }

    public void setProvideCredit(String provideCredit) {
        this.provideCredit = provideCredit;
    }

    public String getOverdueAccount() {
        return overdueAccount;
    }

    public void setOverdueAccount(String overdueAccount) {
        this.overdueAccount = overdueAccount;
    }

    public String getOverdueOrder() {
        return overdueOrder;
    }

    public void setOverdueOrder(String overdueOrder) {
        this.overdueOrder = overdueOrder;
    }

    public String getOverdueTotalMoney() {
        return overdueTotalMoney;
    }

    public void setOverdueTotalMoney(String overdueTotalMoney) {
        this.overdueTotalMoney = overdueTotalMoney;
    }

    @Override
    public String toString() {
        return "ProvideCredit{" +
                "provideCredit='" + provideCredit + '\'' +
                ", overdueAccount='" + overdueAccount + '\'' +
                ", overdueOrder='" + overdueOrder + '\'' +
                ", overdueTotalMoney='" + overdueTotalMoney + '\'' +
                '}';
    }
}
