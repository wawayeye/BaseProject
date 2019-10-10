package com.tuandai.baseproject.dto.qnj;

public class WithdrawDTO {
    private String url;
    private String successTip;

    private Integer status;
    private String title;
    private String content;
    private String projectId;

    private String registerUrl; // 开通厦门银行存管的页面
    private String bindUrl; // 绑卡页面
    private String protocolUrl; // 授权协议支付页面
    private String payFeeUrl;   // 支付服务费的页面

    private String returnUrl;   // 提现结果页

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public void setRegisterUrl(String registerUrl) {
        this.registerUrl = registerUrl;
    }

    public String getBindUrl() {
        return bindUrl;
    }

    public void setBindUrl(String bindUrl) {
        this.bindUrl = bindUrl;
    }

    public String getProtocolUrl() {
        return protocolUrl;
    }

    public void setProtocolUrl(String protocolUrl) {
        this.protocolUrl = protocolUrl;
    }

    public String getPayFeeUrl() {
        return payFeeUrl;
    }

    public void setPayFeeUrl(String payFeeUrl) {
        this.payFeeUrl = payFeeUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuccessTip() {
        return successTip;
    }

    public void setSuccessTip(String successTip) {
        this.successTip = successTip;
    }
}
