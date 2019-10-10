package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 家庭信息
 *
 * @author hujunfei
 * @date 2018-12-01 16:54
 */
public class FamilyInfo {

    /**
     * 省,市,区 (英文逗号区隔)
     */
    @JsonProperty("home_areas")
    private String homeAreas;

    /**
     * 居住街道与门牌号
     */
    @JsonProperty("home_address")
    private String homeAddress;

    /**
     * 居住时长
     */
    @JsonProperty("live_time")
    private Integer liveTime;

    /**
     * 住宅类型:1.租房,2.自有住房,3.父母住房,4.公司宿舍,5.房改房,6.其它
     */
    @JsonProperty("house_type")
    private Integer houseType;

    /**
     * 户籍省市区
     */
    @JsonProperty("permanent_areas")
    private String permanentAreas;

    /**
     * 户籍街道与门牌号
     */
    @JsonProperty("permanent_address")
    private String permanentAddress;

    public String getHomeAreas() {
        return homeAreas;
    }

    public void setHomeAreas(String homeAreas) {
        this.homeAreas = homeAreas;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getPermanentAreas() {
        return permanentAreas;
    }

    public void setPermanentAreas(String permanentAreas) {
        this.permanentAreas = permanentAreas;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public String toString() {
        return "FamilyInfo{" +
                "homeAreas='" + homeAreas + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", liveTime=" + liveTime +
                ", houseType=" + houseType +
                ", permanentAreas='" + permanentAreas + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                '}';
    }
}
