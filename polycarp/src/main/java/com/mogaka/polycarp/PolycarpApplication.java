package com.mogaka.polycarp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * 
 * @author moha
 */
@SpringBootApplication
public class PolycarpApplication {
    
    public static void main(String[] args) {
	SpringApplication.run(PolycarpApplication.class, args);
    }
        
   // @Bean
//    public Docket api() {
//            return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.mogaka.polycarp.controller"))
//                .paths(PathSelectors.any())                          
//                .build()
//                .apiInfo(apiInfo());
//
//    }
//
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Mogaka Friends",
//                "Mogaka Friends.",
//                "v1.0.0",
//                "Terms of service",
//                "info@mogakinsightsa.com",
//                "License of API",
//                "#");
//        return apiInfo;
//    }

}
