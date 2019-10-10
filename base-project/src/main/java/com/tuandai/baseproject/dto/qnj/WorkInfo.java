package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 工作信息
 *
 * @author hujunfei
 * @date 2018-12-01 16:59
 */
public class WorkInfo {

    /**
     * 职业类型 1上班族 2企业主 3个体户 4学生 5自由职业
     */
    @JsonProperty("profession_type")
    private String professionType;

    /**
     * 职业-上班族
     */
    @JsonProperty("work_office_info")
    private WorkOfficeInfo workOfficeInfo;

    /**
     * 职业-企业主
     */
    @JsonProperty("work_enterprise_info")
    private WorkEnterpriseInfo workEnterpriseInfo;

    /**
     * 职业-个体户
     */
    @JsonProperty("work_sole_info")
    private WorkSoleInfo workSoleInfo;

    /**
     * 职业-学生
     */
    @JsonProperty("work_student_info")
    private WorkStudentInfo workStudentInfo;

    /**
     * 职业-自由职业
     */
    @JsonProperty("work_free_info")
    private WorkFreeInfo workFreeInfo;

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }

    public WorkOfficeInfo getWorkOfficeInfo() {
        return workOfficeInfo;
    }

    public void setWorkOfficeInfo(WorkOfficeInfo workOfficeInfo) {
        this.workOfficeInfo = workOfficeInfo;
    }

    public WorkEnterpriseInfo getWorkEnterpriseInfo() {
        return workEnterpriseInfo;
    }

    public void setWorkEnterpriseInfo(WorkEnterpriseInfo workEnterpriseInfo) {
        this.workEnterpriseInfo = workEnterpriseInfo;
    }

    public WorkSoleInfo getWorkSoleInfo() {
        return workSoleInfo;
    }

    public void setWorkSoleInfo(WorkSoleInfo workSoleInfo) {
        this.workSoleInfo = workSoleInfo;
    }

    public WorkStudentInfo getWorkStudentInfo() {
        return workStudentInfo;
    }

    public void setWorkStudentInfo(WorkStudentInfo workStudentInfo) {
        this.workStudentInfo = workStudentInfo;
    }

    public WorkFreeInfo getWorkFreeInfo() {
        return workFreeInfo;
    }

    public void setWorkFreeInfo(WorkFreeInfo workFreeInfo) {
        this.workFreeInfo = workFreeInfo;
    }

    @Override
    public String toString() {
        return "WorkInfo{" +
                "professionType='" + professionType + '\'' +
                ", workOfficeInfo=" + workOfficeInfo +
                ", workEnterpriseInfo=" + workEnterpriseInfo +
                ", workSoleInfo=" + workSoleInfo +
                ", workStudentInfo=" + workStudentInfo +
                ", workFreeInfo=" + workFreeInfo +
                '}';
    }
}
