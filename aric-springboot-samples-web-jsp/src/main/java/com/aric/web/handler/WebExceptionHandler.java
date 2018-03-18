package com.aric.web.handler;

import com.aric.web.exception.WebException;
import com.aric.web.response.RestResponseBody;
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
 * 使用@ControllerAdvice注解来捕获系统抛出异常
 * Created by tom.lee on 2017/7/18.
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
