package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 公积金信息
 *
 * @author hujunfei
 * @date 2018-12-01 14:56
 */
public class HousingSecurity {

    /**
     * 是否缴纳 : 1：否; 2：是
     */
    @JsonProperty("housing_fund_status")
    private String housingFundStatus;

    /**
     * 公积金累积缴纳月数
     */
    @JsonProperty("housing_fund_month")
    private String housingFundMonth;

    public String getHousingFundStatus() {
        return housingFundStatus;
    }

    public void setHousingFundStatus(String housingFundStatus) {
        this.housingFundStatus = housingFundStatus;
    }

    public String getHousingFundMonth() {
        return housingFundMonth;
    }

    public void setHousingFundMonth(String housingFundMonth) {
        this.housingFundMonth = housingFundMonth;
    }

    @Override
    public String toString() {
        return "HousingSecurity{" +
                "housingFundStatus='" + housingFundStatus + '\'' +
                ", housingFundMonth='" + housingFundMonth + '\'' +
                '}';
    }
}
