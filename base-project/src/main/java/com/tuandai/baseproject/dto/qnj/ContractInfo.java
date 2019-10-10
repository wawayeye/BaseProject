package com.tuandai.baseproject.dto.qnj;

/**
 * 合同参数
 *
 * @author hujunfei
 * @date 2018-12-22 20:04
 */
public class ContractInfo {

    private String name;

    private String link;
    /**
     * 合同类型  1 注册服务协议   2 团贷网服务协议  3 提供担保协议书  4 借款合同  5 还款服务委托书
     * 6借款人禁止性规定  7 个人信息查询授权书  8 服务费支付确认书
     */
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContractInfo{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", type=" + type +
                '}';
    }
}
