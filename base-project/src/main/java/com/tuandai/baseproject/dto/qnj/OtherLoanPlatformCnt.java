package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 其他网贷平台使用数量
 *
 * @author hujunfei
 * @date 2018-12-03 11:56
 */
public class OtherLoanPlatformCnt {

    /**
     * 其他网贷平台使用数量
     */
    @JsonProperty("other_loan_platform_cnt")
    private String otherLoanPlatformCnt;

    public String getOtherLoanPlatformCnt() {
        return otherLoanPlatformCnt;
    }

    public void setOtherLoanPlatformCnt(String otherLoanPlatformCnt) {
        this.otherLoanPlatformCnt = otherLoanPlatformCnt;
    }

    @Override
    public String toString() {
        return "OtherLoanPlatformCnt{" +
                "otherLoanPlatformCnt='" + otherLoanPlatformCnt + '\'' +
                '}';
    }
}
