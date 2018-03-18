package com.aric.tomcat.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8088/swagger-ui.html
 *
 * @Time : 2017/12/3 17:01
 * @Author : TOM.LEE
 * @File : SwaggerConfiguration.java
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createAllRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName("所有").select()
                .apis(RequestHandlerSelectors.basePackage("com.aric.tomcat.rest.controller"))
//                .paths(Predicates.or(PathSelectors.regex("/.*")))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Rest API")
                .version("1")
                .build();
    }
}
