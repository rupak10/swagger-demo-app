package com.rupak;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoAppApplication.class, args);
	}
	
	
	
	//custom swagger configuration
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/books").or(PathSelectors.ant("/api/books/*")))
				.apis(RequestHandlerSelectors.basePackage("com.rupak"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Book API",
				"Simple API for managing book resource",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Rupak Kumar Das", "", "rupak.cse010@gmail.com"),
				"API License",
				"rupak.cse010@gmail.com",
				Collections.emptyList());
	}
	
	
}





/*
 * dependency for swagger : 
 * 		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-boot-starter</artifactId>
		    <version>3.0.0</version>
	    </dependency>
 * */

//html documentation path
//http://localhost:8080/swagger-ui/index.html

//json documentation path
//http://localhost:8080/v2/api-docs

