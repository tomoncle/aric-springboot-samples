package com.aric.tomcat.exception;

/**
 * Created by tom.lee on 2017/7/15.
 */

public class WebException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public WebException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public WebException() {
    }


}
