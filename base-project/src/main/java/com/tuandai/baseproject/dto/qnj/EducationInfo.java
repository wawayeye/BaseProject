package com.tuandai.baseproject.dto.qnj;

/**
 * 教育程度
 *
 * @author hujunfei
 * @date 2018-12-01 16:52
 */
public class EducationInfo {

    /**
     * 教育程度
     */
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "EducationInfo{" +
                "degree='" + degree + '\'' +
                '}';
    }
}
