package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 是否有贷款
 *
 * @author hujunfei
 * @date 2018-12-01 16:39
 */
public class IsLoan {

    /**
     * 是否有贷款 1: 否,2: 是
     */
    @JsonProperty("is_loan")
    private String isLoan;

    /**
     * 贷款类型 1: 房屋按揭贷款,2: 个人信用贷款",3: 经营贷款,4: 汽车贷款,5: 教育贷款,6: 其他贷款
     */
    @JsonProperty("loan_type")
    private String loanType;

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "IsLoan{" +
                "isLoan='" + isLoan + '\'' +
                ", loanType='" + loanType + '\'' +
                '}';
    }
}
