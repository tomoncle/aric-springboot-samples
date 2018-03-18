package com.aric.tomcat.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现ErrorController接口是重写BaseErrorController的error实现.
 * 实现HandlerExceptionResolver接口是重写异常解析处理函数
 * Created by tom.lee on 2017/7/16.
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


    /**
     * 具体处理/error接口的异常方法
     * @param httpServletRequest HTTP请求对象
     * @param httpServletResponse Http相应对象
     * @param o 异常类
     * @param e 异常信息
     * @return 返回到系统定义的异常ModelAndView
     */
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object o, Exception e) {
        logger.error("WebErrorController code:" + httpServletResponse.getStatus());
        logger.error("WebErrorController handler:" + o.getClass().getSimpleName());
        return new ModelAndView("/error/500");
    }

    /**
     * 该方法对应getErrorPath方法对应的转发地址 return "/error"，这样就重写的默认的/error地址
     * @param httpServletRequest HTTP请求对象
     * @param httpServletResponse Http相应对象
     * @param o 异常类
     * @param e  异常信息
     * @return  返回到系统统一处理的resolveException
     */
    @RequestMapping
    public ModelAndView error(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        return resolveException(httpServletRequest, httpServletResponse, o, e);
    }


    /**
     *  定义默认错误页面
     *     当你请求一个不存在的连接时，会触发该方法：返回到对应的页面
     *     例如：localhost:8085/notFound 返回404页面
     * @return EmbeddedServletContainerCustomizer
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.jsp");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.jsp");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.jsp");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }

////    @Bean
////    public EmbeddedServletContainerCustomizer containerCustomizer() {
////
////        return new EmbeddedServletContainerCustomizer() {
////            @Override
////            public void customize(ConfigurableEmbeddedServletContainer servletContainer) {
////                System.out.println("EmbeddedServletContainerCustomizer");
////                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error.jsp");
////                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error.jsp");
////                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.jsp");
////                servletContainer.addErrorPages(
////                        error401Page, error404Page, error500Page);
////            }
////
////        };
////    }


}
