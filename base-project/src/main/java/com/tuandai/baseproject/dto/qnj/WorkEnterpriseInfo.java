package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 职业-企业主
 *
 * @author hujunfei
 * @date 2018-12-01 17:28
 */
public class WorkEnterpriseInfo {

    /**
     * 企业名称
     */
    @JsonProperty("own_company_name")
    private String ownCompanyName;

    /**
     * 经营者身份 1.股东，2.法人，3.其它
     */
    @JsonProperty("user_position")
    private Integer userPosition;

    /**
     * 所占股份
     */
    private String share;

    /**
     * 是否已上市: 1:已上市; 2：未上市
     */
    @JsonProperty("own_is_market")
    private Integer ownIsMarket;

    /**
     * 实际经营所在地
     */
    @JsonProperty("own_true_operation_address")
    private String ownTrueOperationAddress;

    /**
     * 所属行业
     */
    @JsonProperty("own_industry")
    private String ownIndustry;

    /**
     * 经营类型
     */
    @JsonProperty("own_manage_type")
    private String ownManageType;

    /**
     * 是否办理营业执照 : 1：否; 2：是
     */
    @JsonProperty("own_is_license")
    private Integer ownIsLicense;

    /**
     * 经营年限1: 不足3个月,2: 3-6个月,3: 7-12个月,4: 1-2年,5: 3-4年,6: 5年及以上
     */
    @JsonProperty("own_manage_life_time")
    private Integer onwManageLifeTime;

    /**
     * 每月总营收（万元）
     */
    @JsonProperty("own_total_revenue")
    private Integer ownTotalRevenue;

    /**
     * 每月对公流水（万元）
     */
    @JsonProperty("public_revenue")
    private Integer publicRevenue;

    /**
     * 每月对私流水（万元）
     */
    @JsonProperty("private_revenue")
    private Integer privateRevenue;

    /**
     * 每月现金结算收益（万元）
     */
    @JsonProperty("own_settle_revenue")
    private Integer ownSettleRevenue;

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

    public String getOwnCompanyName() {
        return ownCompanyName;
    }

    public void setOwnCompanyName(String ownCompanyName) {
        this.ownCompanyName = ownCompanyName;
    }

    public Integer getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(Integer userPosition) {
        this.userPosition = userPosition;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public Integer getOwnIsMarket() {
        return ownIsMarket;
    }

    public void setOwnIsMarket(Integer ownIsMarket) {
        this.ownIsMarket = ownIsMarket;
    }

    public String getOwnTrueOperationAddress() {
        return ownTrueOperationAddress;
    }

    public void setOwnTrueOperationAddress(String ownTrueOperationAddress) {
        this.ownTrueOperationAddress = ownTrueOperationAddress;
    }

    public String getOwnIndustry() {
        return ownIndustry;
    }

    public void setOwnIndustry(String ownIndustry) {
        this.ownIndustry = ownIndustry;
    }

    public String getOwnManageType() {
        return ownManageType;
    }

    public void setOwnManageType(String ownManageType) {
        this.ownManageType = ownManageType;
    }

    public Integer getOwnIsLicense() {
        return ownIsLicense;
    }

    public void setOwnIsLicense(Integer ownIsLicense) {
        this.ownIsLicense = ownIsLicense;
    }

    public Integer getOnwManageLifeTime() {
        return onwManageLifeTime;
    }

    public void setOnwManageLifeTime(Integer onwManageLifeTime) {
        this.onwManageLifeTime = onwManageLifeTime;
    }

    public Integer getOwnTotalRevenue() {
        return ownTotalRevenue;
    }

    public void setOwnTotalRevenue(Integer ownTotalRevenue) {
        this.ownTotalRevenue = ownTotalRevenue;
    }

    public Integer getPublicRevenue() {
        return publicRevenue;
    }

    public void setPublicRevenue(Integer publicRevenue) {
        this.publicRevenue = publicRevenue;
    }

    public Integer getPrivateRevenue() {
        return privateRevenue;
    }

    public void setPrivateRevenue(Integer privateRevenue) {
        this.privateRevenue = privateRevenue;
    }

    public Integer getOwnSettleRevenue() {
        return ownSettleRevenue;
    }

    public void setOwnSettleRevenue(Integer ownSettleRevenue) {
        this.ownSettleRevenue = ownSettleRevenue;
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
        return "WorkEnterpriseInfo{" +
                "ownCompanyName='" + ownCompanyName + '\'' +
                ", userPosition=" + userPosition +
                ", share='" + share + '\'' +
                ", ownIsMarket=" + ownIsMarket +
                ", ownTrueOperationAddress='" + ownTrueOperationAddress + '\'' +
                ", ownIndustry='" + ownIndustry + '\'' +
                ", ownManageType='" + ownManageType + '\'' +
                ", ownIsLicense=" + ownIsLicense +
                ", onwManageLifeTime=" + onwManageLifeTime +
                ", ownTotalRevenue=" + ownTotalRevenue +
                ", publicRevenue=" + publicRevenue +
                ", privateRevenue=" + privateRevenue +
                ", ownSettleRevenue=" + ownSettleRevenue +
                ", companyName='" + companyName + '\'' +
                ", payType='" + payType + '\'' +
                ", revenueArea='" + revenueArea + '\'' +
                '}';
    }
}
