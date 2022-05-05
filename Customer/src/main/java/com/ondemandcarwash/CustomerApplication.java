package com.ondemandcarwash;

import java.util.Arrays;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CustomerApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	public static final String CUSTOMER_TAG = "Customer service";
	  
	 @Bean 
	 public Docket swaggerConfiguration() 
	 { 
		 return new Docket(DocumentationType.SWAGGER_2) 
				 .select()
				 .paths(PathSelectors.ant("/customer/**"))
				 .apis(RequestHandlerSelectors.basePackage("com.ondemandcarwash")) 
				 .build()
				 .tags(new Tag(CUSTOMER_TAG, "the customer API with description api tag"));
	 }
	 

//		@Bean
//		public CorsFilter corsFilter()
//		{
//			CorsConfiguration corsConfiguration = new CorsConfiguration();
//			corsConfiguration.setAllowCredentials(true);
//			corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//			corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//					"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//					"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//			corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//					"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//			corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//			UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//			urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//			return new CorsFilter(urlBasedCorsConfigurationSource);
//		}

}
