package com.tuandai.baseproject.dto.qnj;

/**
 * @Author: xzj
 * @Dscription：  信用卡邮箱 银行信息
 * @Date: Created by 11:40 2018/12/9
 */
public class CardBankInfo {

    /**
     * 持卡人姓名
     */
    private String nameOnCard;

    /**
     *  银行卡名称
     */
    private String bankName;

    /**
     * 银行卡号 后四位
     */
    private String cardNo;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


}
