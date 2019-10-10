package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 职业-学生
 *
 * @author hujunfei
 * @date 2018-12-01 17:49
 */
public class WorkStudentInfo {

    /**
     * 学校名称
     */
    @JsonProperty("school_name")
    private String schoolName;

    /**
     * 学校所在城市
     */
    @JsonProperty("school_location")
    private String schoolLocation;

    /**
     * 入学年份
     */
    private Integer entrance;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public Integer getEntrance() {
        return entrance;
    }

    public void setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    @Override
    public String toString() {
        return "WorkStudentInfo{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolLocation='" + schoolLocation + '\'' +
                ", entrance=" + entrance +
                '}';
    }
}
