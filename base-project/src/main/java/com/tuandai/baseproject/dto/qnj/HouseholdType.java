package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 户口性质
 *
 * @author hujunfei
 * @date 2018-12-03 11:54
 */
public class HouseholdType {

    /**
     * 户口性质 1 农村, 2 城市
     */
    @JsonProperty("household_type")
    private String householdType;

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    @Override
    public String toString() {
        return "HouseholdType{" +
                "householdType='" + householdType + '\'' +
                '}';
    }
}
