package com.cognizant.insurance;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 *         With the @SpringBootTest annotation, Spring Boot provides a
 *         convenient way to start up an application context to be used in a
 *         test
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class InsuranceClaimMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main() {
		InsuranceClaimMicroserviceApplication.main(new String[] {});
	}

}
