package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 职业-自由职业
 *
 * @author hujunfei
 * @date 2018-12-01 17:53
 */
public class WorkFreeInfo {

    /**
     * 自由职业收入
     */
    @JsonProperty("free_income")
    private String freeIncome;

    /**
     * 公司名称
     */
    @JsonProperty("company_name")
    private String companyName;

    /**
     * 工资发放形式: 1.银行代发 2.现金发放 3.部分银行部分现金
     */
    @JsonProperty("pay_type")
    private String payType;

    /**
     * 月工资: 1.3000及以下,2.3000-5000,3.5000-10000,4.10000以上
     */
    @JsonProperty("revenue_area")
    private String revenueArea;

    public String getFreeIncome() {
        return freeIncome;
    }

    public void setFreeIncome(String freeIncome) {
        this.freeIncome = freeIncome;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRevenueArea() {
        return revenueArea;
    }

    public void setRevenueArea(String revenueArea) {
        this.revenueArea = revenueArea;
    }

    @Override
    public String toString() {
        return "WorkFreeInfo{" +
                "freeIncome='" + freeIncome + '\'' +
                ", companyName='" + companyName + '\'' +
                ", payType='" + payType + '\'' +
                ", revenueArea='" + revenueArea + '\'' +
                '}';
    }
}
