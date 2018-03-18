package com.aric.tomcat.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * main
 * Created by tom.lee on 2017/11/21.
 */
@Import({LoadSystemEnvironment.class})
@Configuration
@EnableAutoConfiguration(exclude = {JacksonAutoConfiguration.class})
@ComponentScan(basePackages = {"com.aric"})
public class BootStart extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(BootStart.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext application = SpringApplication.run(BootStart.class, args);
        if (logger.isDebugEnabled()) {
            String[] beanDefinitionNames = application.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                logger.debug(beanName);
            }
        }
        logger.info("started server HTTP server on [::]:" + System.getProperty("server.port"));
    }

}
