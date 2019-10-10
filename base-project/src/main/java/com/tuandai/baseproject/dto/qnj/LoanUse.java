package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 借款用途
 *
 * @author hujunfei
 * @date 2018-12-01 16:41
 */
public class LoanUse {

    /**
     * 贷款用途 1: 装修,2: 婚庆,3: 旅游,4: 教育,5: 租房,6: 汽车周边,
     * 7: 电子数码产品,8: 医疗,9: 其他,10: 家用电器,11: 家具家居
     */
    @JsonProperty("loan_use")
    private String loanUse;

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    @Override
    public String toString() {
        return "LoanUse{" +
                "loanUse='" + loanUse + '\'' +
                '}';
    }
}
