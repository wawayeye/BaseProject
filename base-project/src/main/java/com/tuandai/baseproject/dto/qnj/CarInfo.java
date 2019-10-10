package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 车辆信息
 *
 * @author hujunfei
 * @date 2018-11-30 17:55
 */
public class CarInfo {

    /**
     * 车辆状况 1：有车贷，2.无抵押，3.无车贷，4.无抵押，无车贷
     */
    @JsonProperty("car_status")
    private int carStatus;

    /**
     * 车辆价格
     */
    @JsonProperty("car_price")
    private String carPrice;

    /**
     * 车辆使用年限
     */
    @JsonProperty("car_life_time")
    private String carLifeTime;

    public int getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(int carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarLifeTime() {
        return carLifeTime;
    }

    public void setCarLifeTime(String carLifeTime) {
        this.carLifeTime = carLifeTime;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carStatus=" + carStatus +
                ", carPrice='" + carPrice + '\'' +
                ", carLifeTime='" + carLifeTime + '\'' +
                '}';
    }
}
