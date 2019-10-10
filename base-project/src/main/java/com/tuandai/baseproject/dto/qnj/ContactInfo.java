package com.tuandai.baseproject.dto.qnj;

/**
 * 紧急联系人
 *
 * @author hujunfei
 * @date 2018-11-30 17:52
 */
public class ContactInfo {

    /**
     * 0 第一联系人  1 第二联系人
     */
    private String ranking;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 与用户关系
     */
    private String relation;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "ranking='" + ranking + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}
