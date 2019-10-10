package com.tuandai.baseproject.util;

import com.tuandai.baseproject.enums.MsgCodeEnum;

/**
 * 自定义运行时异常
 *
 * @author hujunfei
 * @date 2018-11-23 16:30
 */
public class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BaseRuntimeException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseRuntimeException(String msg, Exception e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseRuntimeException(int code, String msg) {
        this(msg);
        this.code = code;
    }

    public BaseRuntimeException(int code, String msg, Exception e) {
        this(msg, e);
        this.code = code;
    }

    public BaseRuntimeException(MsgCodeEnum msgCodeEnum) {
        super(msgCodeEnum.getMsg());
        this.msg = msgCodeEnum.getMsg();
        this.code = msgCodeEnum.getCode();
    }
}
