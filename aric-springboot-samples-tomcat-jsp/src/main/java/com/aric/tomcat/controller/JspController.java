package com.aric.tomcat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

/**
 *
 * Created by tom.lee on 2017/1/28.
 */
@Controller
public class JspController {

    private static Logger logger = LoggerFactory.getLogger(JspController.class);

    /**
     * 测试页面异常
     * @return WebExceptionHandler.handleMyRuntimeException
     * @throws Exception
     */
    @RequestMapping("/")
    public String jspView() throws Exception{
        throw new IllegalAccessException("测试页面异常");
    }

    /**
     * 测试ResponseBody异常
     * @return  WebExceptionHandler.handleMyRuntimeException
     * @throws Exception
     */
    @RequestMapping(value = "/num",method = RequestMethod.POST)
    public @ResponseBody int num()throws Exception{
        int a = 1/0; // 测试是否抛出异常
        logger.info("计算a的值：" + a);
        return 100;
    }

}
