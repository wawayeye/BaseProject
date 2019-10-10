package com.tuandai.baseproject.common;

/**
 * 返回API调用者实体类
 */
public class ResultJson {
    private Integer code;//状态码
    private Boolean isSuccess;//状态
    private String massege;//消息
    private Object result;//数据对象
    /**
     * 无参构造器
     */
    public ResultJson(){
        super();
    }

    /**
     * 只返回状态，状态码，消息
     * @param success
     * @param code
     * @param massege
     */
    public ResultJson(Boolean success, Integer code, String massege){
        super();
        this.isSuccess=success;
        this.code=code;
        this.massege=massege;
    }

    /**
     * 只返回状态，状态码，数据对象
     * @param success
     * @param code
     * @param result
     */
    public ResultJson(Boolean success, Integer code, Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.result=result;
    }

    public ResultJson(Boolean success, Integer code, String massege, Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.massege=massege;
        this.result=result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"isSuccess\":" + isSuccess +
                ", \"massege\":\"" + massege + '\"' +
                ", \"result\":" + result +
                '}';
    }
}
