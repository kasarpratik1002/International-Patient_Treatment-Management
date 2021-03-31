package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * @SpringBootApplication is used in our application or main class to enable a
 *                        host of features, e.g. Java-based Spring
 *                        configuration, component scanning, and in particular
 *                        for enabling Spring Boot's auto-configuration feature.
 *
 */


@EnableFeignClients
@SpringBootApplication
public class IpTreatmentWebPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentWebPortalApplication.class, args);
	}

}
