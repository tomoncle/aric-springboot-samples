package com.aric.tomcat.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liyuanjun on 16-10-9.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.aric.tomcat")
@EnableCaching
public class App extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext application = SpringApplication.run(App.class, args);
        if (logger.isDebugEnabled()) {
            String[] beanDefinitionNames = application.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                logger.debug(beanName);
            }
        }
    }

}