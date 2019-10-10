package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 行业类型
 *
 * @author hujunfei
 * @date 2018-12-01 15:23
 */
public class BusinessType {

    /**
     * 行业类型
     * 1商业、服务人员 2专业技术人员 3办事人员、文员、行政等
     * 4工厂、生产、运输人员 5农、林、牧、渔、水利业人员 6前线销售人员
     * 7国家机关、企事业单位管理人员 8军人 9在校学生
     */
    @JsonProperty("business_type")
    private String businessType;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "BusinessType{" +
                "businessType='" + businessType + '\'' +
                '}';
    }
}
