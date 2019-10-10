package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 用户补充信息
 *
 * @author hujunfei
 * @date 2018-12-03 12:34
 */
public class  UserAdditional {

    /**
     * 设备信息
     */
    @JsonProperty("device_info")
    private DeviceInfo deviceInfo;

    /**
     * 通讯录信息
     */
    @JsonProperty("address_book")
    private AddressBook addressBook;

    /**
     * 紧急联系人信息
     */
    @JsonProperty("contact_info_custom")
    private List<ContactInfo> contactInfos;

    /**
     * 车辆信息
     */
    @JsonProperty("car_info")
    private CarInfo carInfo;

    /**
     * 房产信息
     */
    @JsonProperty("house_info")
    private HouseInfo houseInfo;

    /**
     * 社保信息
     */
    @JsonProperty("social_security")
    private SocialSecurity socialSecurity;

    /**
     * 公积金信息
     */
    @JsonProperty("housing_security")
    private HousingSecurity housingSecurity;

    /**
     * 信用状态
     */
    @JsonProperty("credit_info")
    private CreditInfo creditInfo;

    /**
     * 婚姻状况
     */
    private Marriage marriage;

    /**
     * 联系方式
     */
    private Email email;

    /**
     * 行业类型
     */
    @JsonProperty("business_type")
    private BusinessType businessType;

    /**
     * 收入来源
     */
    @JsonProperty("revenue_source")
    private RevenueSource revenueSource;

    /**
     * 是否有贷款
     */
    @JsonProperty("is_loan")
    private IsLoan isLoan;

    /**
     * 贷款用途
     */
    @JsonProperty("loan_use")
    private LoanUse loanUse;

    /**
     * 教育程度
     */
    @JsonProperty("education_info")
    private EducationInfo educationInfo;

    /**
     * 家庭信息
     */
    @JsonProperty("family_info")
    private FamilyInfo familyInfo;

    /**
     * 工作信息
     */
    @JsonProperty("work_info")
    private WorkInfo workInfo;

    /**
     * 户口性质
     */
    @JsonProperty("household_type")
    private HouseholdType householdType;

    /**
     * 是否提供人行征信
     */
    @JsonProperty("provide_credit")
    private ProvideCredit provideCredit;

    /**
     * 其他网贷平台使用数量
     */
    @JsonProperty("other_loan_platform_cnt")
    private OtherLoanPlatformCnt otherLoanPlatformCnt;

    /**
     * 其他网贷平台总借款金额
     */
    @JsonProperty("other_loan_amount")
    private OtherLoanAmount otherLoanAmount;

    /**
     * 总负债金额
     */
    private Liability liability;

    /**
     * 是否有行政处罚  1 无  2 有
     */
    @JsonProperty("administrative_sanction")
    private AdministrativeSanction administrativeSanction;

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public HouseInfo getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(HouseInfo houseInfo) {
        this.houseInfo = houseInfo;
    }

    public SocialSecurity getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(SocialSecurity socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public HousingSecurity getHousingSecurity() {
        return housingSecurity;
    }

    public void setHousingSecurity(HousingSecurity housingSecurity) {
        this.housingSecurity = housingSecurity;
    }

    public CreditInfo getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(CreditInfo creditInfo) {
        this.creditInfo = creditInfo;
    }

    public Marriage getMarriage() {
        return marriage;
    }

    public void setMarriage(Marriage marriage) {
        this.marriage = marriage;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public RevenueSource getRevenueSource() {
        return revenueSource;
    }

    public void setRevenueSource(RevenueSource revenueSource) {
        this.revenueSource = revenueSource;
    }

    public IsLoan getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(IsLoan isLoan) {
        this.isLoan = isLoan;
    }

    public LoanUse getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(LoanUse loanUse) {
        this.loanUse = loanUse;
    }

    public EducationInfo getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(EducationInfo educationInfo) {
        this.educationInfo = educationInfo;
    }

    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    public WorkInfo getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(WorkInfo workInfo) {
        this.workInfo = workInfo;
    }

    public HouseholdType getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(HouseholdType householdType) {
        this.householdType = householdType;
    }

    public ProvideCredit getProvideCredit() {
        return provideCredit;
    }

    public void setProvideCredit(ProvideCredit provideCredit) {
        this.provideCredit = provideCredit;
    }

    public OtherLoanPlatformCnt getOtherLoanPlatformCnt() {
        return otherLoanPlatformCnt;
    }

    public void setOtherLoanPlatformCnt(OtherLoanPlatformCnt otherLoanPlatformCnt) {
        this.otherLoanPlatformCnt = otherLoanPlatformCnt;
    }

    public OtherLoanAmount getOtherLoanAmount() {
        return otherLoanAmount;
    }

    public void setOtherLoanAmount(OtherLoanAmount otherLoanAmount) {
        this.otherLoanAmount = otherLoanAmount;
    }

    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    public AdministrativeSanction getAdministrativeSanction() {
        return administrativeSanction;
    }

    public void setAdministrativeSanction(AdministrativeSanction administrativeSanction) {
        this.administrativeSanction = administrativeSanction;
    }

    @Override
    public String toString() {
        return "UserAdditional{" +
                "deviceInfo=" + deviceInfo +
                ", addressBook=" + addressBook +
                ", contactInfos=" + contactInfos +
                ", carInfo=" + carInfo +
                ", houseInfo=" + houseInfo +
                ", socialSecurity=" + socialSecurity +
                ", housingSecurity=" + housingSecurity +
                ", creditInfo=" + creditInfo +
                ", marriage=" + marriage +
                ", email=" + email +
                ", businessType=" + businessType +
                ", revenueSource=" + revenueSource +
                ", isLoan=" + isLoan +
                ", loanUse=" + loanUse +
                ", educationInfo=" + educationInfo +
                ", familyInfo=" + familyInfo +
                ", workInfo=" + workInfo +
                ", householdType=" + householdType +
                ", provideCredit=" + provideCredit +
                ", otherLoanPlatformCnt=" + otherLoanPlatformCnt +
                ", otherLoanAmount=" + otherLoanAmount +
                ", liability=" + liability +
                ", administrativeSanction=" + administrativeSanction +
                '}';
    }
}
