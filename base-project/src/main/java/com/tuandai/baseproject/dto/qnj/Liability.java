package com.tuandai.baseproject.dto.qnj;

/**
 * 总负债金额
 *
 * @author hujunfei
 * @date 2018-12-03 11:58
 */
public class Liability {

    /**
     * 总负债金额
     */
    private String liability;

    public String getLiability() {
        return liability;
    }

    public void setLiability(String liability) {
        this.liability = liability;
    }

    @Override
    public String toString() {
        return "Liability{" +
                "liability='" + liability + '\'' +
                '}';
    }
}
