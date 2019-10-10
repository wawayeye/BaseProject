package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 社保信息
 *
 * @author hujunfei
 * @date 2018-11-30 18:08
 */
public class SocialSecurity {

    /**
     * 是否缴纳 : 1：否; 2：是
     */
    @JsonProperty("social_ins_status")
    private int socialInsStatus;

    /**
     * 社保累积缴纳月数
     */
    @JsonProperty("social_ins_month")
    private int socialInsMonth;

    public int getSocialInsStatus() {
        return socialInsStatus;
    }

    public void setSocialInsStatus(int socialInsStatus) {
        this.socialInsStatus = socialInsStatus;
    }

    public int getSocialInsMonth() {
        return socialInsMonth;
    }

    public void setSocialInsMonth(int socialInsMonth) {
        this.socialInsMonth = socialInsMonth;
    }

    @Override
    public String toString() {
        return "SocialSecurity{" +
                "socialInsStatus=" + socialInsStatus +
                ", socialInsMonth=" + socialInsMonth +
                '}';
    }
}
