package com.aric.tomcat.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 *
 * 加载系统环境变量
 * 实现接口 EnvironmentAware
 * 重写方法 setEnvironment
 * 可以在工程启动时，获取到系统环境变量和application配置文件中的变量
 *
 * Created by Tom.lee on 2017/11/21.
 */
@Configuration
public class LoadSystemEnvironment implements EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(LoadSystemEnvironment.class);

    @Override
    public void setEnvironment(Environment environment) {
        System.setProperty("server.port",environment.getProperty("server.port"));

        // system var
        logger.info("JAVA_HOME: "+environment.getProperty("JAVA_HOME"));

        // application var
        logger.info("boot.name: "+environment.getProperty("boot.name"));

        // 加载include配置文件
        logger.info("加载include配置文件："+environment.getProperty("include.file.name"));

        // 加载默认配置app.agent，假如值为空，则加载默认环境变量配置"APP_AGENT"("APP_AGENT"的变量名在配置文件中定义)
        // !!! APP_AGENT环境变量的作用域一定要包含Java进程所在的作用域
        logger.info("app.agent:"+environment.getProperty("app.agent"));

    }
}
