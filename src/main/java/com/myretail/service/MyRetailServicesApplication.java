package com.myretail.service;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This application exposes RESTful Api's for myRetail.
 * It connects to a Cassandra database for pricing information.
 * It connects to an service to retrieve product information.    
 * 
 * It uses Swagger for documentation and Actuator for monitoring.
 *  
 * @author Gerson Bothello
 *
 */
@SpringBootApplication
@EnableFeignClients("com.myretail.service.product.controller.v1.api")
@EnableSwagger2
public class MyRetailServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailServicesApplication.class, args);
	}

	/**
	 * Swagger configuration to customize the UI.
	 *  
	 * @return the Docket object with the custom data. 
	 */
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.myretail")).build().apiInfo(apiInfo());

	}

	/**
	 * This method is used by Swagger configuration to customize the UI contact information. 
	 * 
	 * @return the ApiInfo object.  
	 */
	private ApiInfo apiInfo() {

		return new ApiInfo("myRetail Service", "", "Version  1.0", "",
				new springfox.documentation.service.Contact("", "", ""),
				"", "", Collections.emptyList());

	}

}
