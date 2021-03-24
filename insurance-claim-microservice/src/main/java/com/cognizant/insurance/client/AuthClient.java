package com.cognizant.insurance.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.insurance.model.AuthResponse;

/**
*  
* @author Pratik K, Pratik B, Shubham, Kavya
*
*         Feign provides an abstraction over REST-based calls via annotation,
*         by which microservices can communicate with each other without
*         writing detailed REST client code 
*         In the @FeignClient annotation the
*         String value ("AUTH") is an arbitrary client name, which is used to
*         create a Ribbon load balancer
*/
@FeignClient(url="localhost:8083/auth",name="AUTH")
public interface AuthClient {
	
	/**
	 * to verify the token that the user request is valid
	 * 
	 * @param token
	 * @return AuthResponse
	 */
	@GetMapping(path="/validate")
	public AuthResponse verifyToken(@RequestHeader(name="Authorization",required=true)String token);
	

}
