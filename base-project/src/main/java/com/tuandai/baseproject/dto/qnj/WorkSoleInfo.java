package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 职业-个体户
 *
 * @author hujunfei
 * @date 2018-12-01 17:38
 */
public class WorkSoleInfo {

    /**
     * 实际经营所在地
     */
    @JsonProperty("sole_true_operation_address")
    private String soleTrueOperationAddress;

    /**
     * 所属行业
     */
    @JsonProperty("sole_industry")
    private String soleIndustry;

    /**
     * 经营类型
     */
    @JsonProperty("sole_manage_type")
    private String soleManageType;

    /**
     * 是否办理营业执照 : 1：是; 0：否
     */
    @JsonProperty("sole_is_license")
    private String soleIsLicense;

    /**
     * 经营年限1: 不足3个月,2: 3-6个月,3: 7-12个月,4: 1-2年,5: 3-4年,6: 5年及以上
     */
    @JsonProperty("sole_manage_life_time")
    private String soleManageLifeTime;

    /**
     * 每月总营收（万元）
     */
    @JsonProperty("sole_total_revenue")
    private String soleTotalRevenue;

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

    public String getSoleTrueOperationAddress() {
        return soleTrueOperationAddress;
    }

    public void setSoleTrueOperationAddress(String soleTrueOperationAddress) {
        this.soleTrueOperationAddress = soleTrueOperationAddress;
    }

    public String getSoleIndustry() {
        return soleIndustry;
    }

    public void setSoleIndustry(String soleIndustry) {
        this.soleIndustry = soleIndustry;
    }

    public String getSoleManageType() {
        return soleManageType;
    }

    public void setSoleManageType(String soleManageType) {
        this.soleManageType = soleManageType;
    }

    public String getSoleIsLicense() {
        return soleIsLicense;
    }

    public void setSoleIsLicense(String soleIsLicense) {
        this.soleIsLicense = soleIsLicense;
    }

    public String getSoleManageLifeTime() {
        return soleManageLifeTime;
    }

    public void setSoleManageLifeTime(String soleManageLifeTime) {
        this.soleManageLifeTime = soleManageLifeTime;
    }

    public String getSoleTotalRevenue() {
        return soleTotalRevenue;
    }

    public void setSoleTotalRevenue(String soleTotalRevenue) {
        this.soleTotalRevenue = soleTotalRevenue;
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
        return "WorkSoleInfo{" +
                "soleTrueOperationAddress='" + soleTrueOperationAddress + '\'' +
                ", soleIndustry='" + soleIndustry + '\'' +
                ", soleManageType='" + soleManageType + '\'' +
                ", soleIsLicense='" + soleIsLicense + '\'' +
                ", soleManageLifeTime='" + soleManageLifeTime + '\'' +
                ", soleTotalRevenue='" + soleTotalRevenue + '\'' +
                ", companyName='" + companyName + '\'' +
                ", payType='" + payType + '\'' +
                ", revenueArea='" + revenueArea + '\'' +
                '}';
    }
}
