package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 职业-上班族
 *
 * @author hujunfei
 * @date 2018-12-01 17:02
 */
public class WorkOfficeInfo {

    /**
     * 公司名称
     */
    @JsonProperty("company_name")
    private String companyName;

    /**
     * 公司地区：省,市,区 (英文逗号区隔)
     */
    @JsonProperty("company_areas")
    private String companyAreas;

    /**
     * 公司地址
     */
    @JsonProperty("company_address")
    private String companyAddress;

    /**
     * 公司类型：1.政府或企事业单位，2.央企国企，3.外资企业，4.上市公司，5.民营企业，6.个体工商户
     */
    @JsonProperty("company_type")
    private String companyType;

    /**
     * 当前单位工龄: 1.0-5个月,2.6-11个月; 3.1-3年; 4.3-7年 5.7年以上
     */
    @JsonProperty("work_age")
    private String workAge;

    /**
     * 工资发放形式: 1.银行代发 2.现金发放 3.部分银行部分现金
     */
    @JsonProperty("pay_type")
    private String payType;

    /**
     * 月收入
     */
    private String revenue;

    /**
     * 月工资: 1.3000及以下,2.3000-5000,3.5000-10000,4.10000以上
     */
    @JsonProperty("revenue_area")
    private String revenueArea;

    /**
     * 工作职位 :1.普通员工,2.部门主管,3.部门总监,4.公司高管
     */
    @JsonProperty("company_position")
    private String companyPosition;

    /**
     * 公司电话(包含区号,分机号)
     */
    @JsonProperty("company_tel")
    private String companyTel;

    /**
     * 公司电话
     */
    @JsonProperty("tel_no")
    private String telNo;

    /**
     * 公司电话区号
     */
    @JsonProperty("tel_area")
    private String telArea;

    /**
     * 公司邮箱
     */
    @JsonProperty("company_email")
    private String companyEmail;

    /**
     * 工资发放日
     */
    @JsonProperty("pay_day")
    private Integer payDay;

    /**
     * 入职时间
     */
    @JsonProperty("company_entry_date")
    private String companyEntryDate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAreas() {
        return companyAreas;
    }

    public void setCompanyAreas(String companyAreas) {
        this.companyAreas = companyAreas;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getRevenueArea() {
        return revenueArea;
    }

    public void setRevenueArea(String revenueArea) {
        this.revenueArea = revenueArea;
    }

    public String getCompanyPosition() {
        return companyPosition;
    }

    public void setCompanyPosition(String companyPosition) {
        this.companyPosition = companyPosition;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTelArea() {
        return telArea;
    }

    public void setTelArea(String telArea) {
        this.telArea = telArea;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public String getCompanyEntryDate() {
        return companyEntryDate;
    }

    public void setCompanyEntryDate(String companyEntryDate) {
        this.companyEntryDate = companyEntryDate;
    }

    @Override
    public String toString() {
        return "WorkOfficeInfo{" +
                "companyName='" + companyName + '\'' +
                ", companyAreas='" + companyAreas + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyType='" + companyType + '\'' +
                ", workAge='" + workAge + '\'' +
                ", payType='" + payType + '\'' +
                ", revenue='" + revenue + '\'' +
                ", revenueArea='" + revenueArea + '\'' +
                ", companyPosition='" + companyPosition + '\'' +
                ", companyTel='" + companyTel + '\'' +
                ", telNo='" + telNo + '\'' +
                ", telArea='" + telArea + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", payDay='" + payDay + '\'' +
                ", companyEntryDate='" + companyEntryDate + '\'' +
                '}';
    }
}
