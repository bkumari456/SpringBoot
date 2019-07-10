package com.example.demo.config;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(basePackage("com.example.demo.controller"))
				.paths(regex("/rest.*"))
				.build()
				.apiInfo(apiInfo())
				;
	}
	public ApiInfo apiInfo() {
		return new ApiInfo(
				"Spring Boot Employee App", 
				"welcome to my Application", 
				"Snap-1.0", "https://sathyatech.com/", 
				new Contact(
						"RSS", 
						"http://sathyatech.com", 
						"javabyraghu@gmail.com"
						), 
				"Apache XYZ", "https://sathyatech.com/", new ArrayList<VendorExtension>());
	}



}




