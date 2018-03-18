package com.aric.tomcat.handler;

import com.aric.tomcat.exception.WebException;
import com.aric.tomcat.response.RestResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用@ControllerAdvice注解来捕获系统抛出异常，触发该异常处理类
 * Created by liyuanjun on 17-7-20.
 */
@ControllerAdvice
public class WebExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponseBody handleMyRuntimeException(
            HttpServletRequest request, HttpServletResponse response, Exception exception) {
        /**
         * 假如为系统自定义异常获取异常信息
         */
        logger.error("WebExceptionHandler error:" + response.getStatus());
        if (exception instanceof WebException) {
            WebException webException = (WebException) exception;
            return new RestResponseBody(webException.getCode(), webException.getMessage(), null);
        }
        /**
         * 抛出未知状态码
         */
        return new RestResponseBody(-1, exception.getMessage(), null);
    }
}
