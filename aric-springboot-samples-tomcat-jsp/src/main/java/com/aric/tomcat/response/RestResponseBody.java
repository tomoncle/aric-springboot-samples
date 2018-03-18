package com.aric.tomcat.response;

/**
 * 响应实体
 * Created by tom.lee on 2017/7/18.
 */
public class RestResponseBody {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestResponseBody(int code,String message,Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public RestResponseBody(){

    }



}
