package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 收入来源
 *
 * @author hujunfei
 * @date 2018-12-01 15:25
 */
public class RevenueSource {

    /**
     * 收入来源 1: 工资奖金,2: 经营收入,3: 投资理财,4: 房租收入,5: 其他收入
     */
    @JsonProperty("revenue_source")
    private String revenueSource;

    public String getRevenueSource() {
        return revenueSource;
    }

    public void setRevenueSource(String revenueSource) {
        this.revenueSource = revenueSource;
    }

    @Override
    public String toString() {
        return "RevenueSource{" +
                "revenueSource='" + revenueSource + '\'' +
                '}';
    }
}
