package com.aric.web.controller;

import com.aric.web.exception.WebException;
import com.aric.web.response.ResponseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyuanjun on 16-10-9.
 */
@Controller
public class JspController {

    @Value("${system.message:Hello World}")
    private String message="hello tom.lee";

    @RequestMapping("/")
    String index(){
        System.out.println("index...");
        return "index";
    }


    /**
     * @return hello.jsp
     */
    @RequestMapping("/hello")
    String welcome() {
        System.out.println(this.message);
        return "hello";
    }


    /**
     * 测试异常
     * @return
     * @throws Exception
     */
    @RequestMapping("/failHtml")
    public String failHtml() throws Exception{
        throw new IllegalAccessException("");
    }

    /**
     * 测试异常
     * @return
     */
    @RequestMapping("/fail")
    @ResponseBody
    public String fail() {
        throw new WebException(ResponseCode.error,"test json exception!");
    }


    @RequestMapping("/data")
    @ResponseBody
    String data(){
        return this.message;
    }


}
