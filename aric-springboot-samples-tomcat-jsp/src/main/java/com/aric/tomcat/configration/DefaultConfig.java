//package com.aric.tomcat.configration;
//
//import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//
//import javax.servlet.DispatcherType;
//import java.util.EnumSet;
//
///**
// * Created by tom.lee on 2017/7/15.
// * 配置默认设置
// */
////@Configuration
//public class DefaultConfig extends WebMvcAutoConfigurationAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        System.out.println("DefaultConfig addViewControllers");
//        registry.addViewController("/").setViewName("forward:index.jsp");
//    }
//
//    @Bean
//    public FilterRegistrationBean myFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new MyFilter());
//        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
//        return registration;
//    }
//
//}
