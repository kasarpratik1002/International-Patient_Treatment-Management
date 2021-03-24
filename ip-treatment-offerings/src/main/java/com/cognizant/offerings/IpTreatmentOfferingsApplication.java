package com.cognizant.offerings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		@SpringBootApplication is used in our application or main class to enable a
 *      host of features, e.g. Java-based Spring configuration, 
 *      component scanning, and in particular for enabling 
 *      Spring Boot's auto-configuration feature.
 * 		@EnableFeignClients scans for interfaces that declare they are 
 * 		feign clients (via @FeignClient )
 *
 */
@SpringBootApplication(scanBasePackages = { "com.cognizant" })
@EnableFeignClients
public class IpTreatmentOfferingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentOfferingsApplication.class, args);
	}

	/**
	 * to create bean for Rest Template to auto wiring the Rest Template object
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
