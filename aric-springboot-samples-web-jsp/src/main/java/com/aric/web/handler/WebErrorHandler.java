package com.aric.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现ErrorController接口是重写BaseErrorController的error实现.
 * 实现HandlerExceptionResolver接口是重写异常解析处理函数
 * Created by tom.lee on 2017/7/18.
 */
@Controller
@RequestMapping("/error")
public class WebErrorHandler implements ErrorController, HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(WebErrorHandler.class);

    /**
     * 重写BaseErrorController的error实现
     * @return 处理异常的连接地址
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /***
     * 重写 HandlerExceptionResolver 的解析方法
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o 操作的对象
     * @param e 异常信息
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String uri = httpServletRequest.getRequestURI();
        logger.error("异常的url是：" + uri +"; 错误码:" + httpServletResponse.getStatus());
        return new ModelAndView("error/404");
    }

    /***
     * 映射/error 接口，重写BaseErrorController的error实现
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o 操作的对象
     * @param e 异常信息
     * @return ModelAndView
     */
    @RequestMapping
    public ModelAndView error(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        return resolveException(httpServletRequest, httpServletResponse, o, e);
    }

}
