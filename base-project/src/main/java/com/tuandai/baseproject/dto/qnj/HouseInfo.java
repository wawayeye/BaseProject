package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 房产信息
 *
 * @author hujunfei
 * @date 2018-11-30 17:57
 */
public class HouseInfo {

    /**
     * 房产类型
     */
    @JsonProperty("house_status")
    private int houseStatus;

    /**
     * 房产所在地
     */
    private String location;

    /**
     * 房产市值
     */
    @JsonProperty("house_price")
    private String housePrice;

    /**
     * 是否有按揭 : 1：否; 2：是
     */
    @JsonProperty("house_loan_status")
    private int houseLoanStatus;

    /**
     * 房屋是否抵押 : 1：否; 2：是
     */
    @JsonProperty("house_pledge_status")
    private int housePledgeStatus;

    public int getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(int houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public int getHouseLoanStatus() {
        return houseLoanStatus;
    }

    public void setHouseLoanStatus(int houseLoanStatus) {
        this.houseLoanStatus = houseLoanStatus;
    }

    public int getHousePledgeStatus() {
        return housePledgeStatus;
    }

    public void setHousePledgeStatus(int housePledgeStatus) {
        this.housePledgeStatus = housePledgeStatus;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "houseStatus=" + houseStatus +
                ", location='" + location + '\'' +
                ", housePrice='" + housePrice + '\'' +
                ", houseLoanStatus=" + houseLoanStatus +
                ", housePledgeStatus=" + housePledgeStatus +
                '}';
    }
}
