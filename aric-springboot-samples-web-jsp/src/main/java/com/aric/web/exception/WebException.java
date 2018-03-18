package com.aric.web.exception;

/**
 * 定义系统异常类
 * RuntimeException 事务回滚
 * Created by tom.lee on 2017/7/18.
 */
public class WebException extends RuntimeException {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public WebException(int code,String message){
       super(message);
       this.code=code;
    }
}
