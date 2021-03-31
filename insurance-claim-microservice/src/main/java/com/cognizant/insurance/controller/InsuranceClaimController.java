package com.cognizant.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.insurance.client.AuthClient;
import com.cognizant.insurance.exception.InvalidTokenException;
import com.cognizant.insurance.model.AuthResponse;
import com.cognizant.insurance.model.InitiateClaim;
import com.cognizant.insurance.model.InsurerDetail;
import com.cognizant.insurance.service.InsuranceClaimServiceImpl;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 *
 * @Controller annotation is used to mark any java class as a controller class
 * @RequestMapping annotation is used to map the web request "/IPTMS"
 * @Slf4j (Simple Logging Facade for Java) provides a simple abstraction of all
 *        the logging frameworks
 */
@RestController

@RequestMapping("/iptms")
public class InsuranceClaimController {

	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 * microservice autowires the InsuranceClaimService
	 */
	@Autowired
	AuthClient authclient;

	@Autowired
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;

	/**
	 * Method-GET, http://localhost:9092/iptms/getallinsurerdetail
	 * 
	 * to get the list of insurers available for the patients only after verifying
	 * that the user trying to use this service is authenticated or not
	 * 
	 * @param token
	 * @return
	 * @throws InvalidTokenException
	 */
	@GetMapping(value = "/getallinsurerdetail")
	public List<InsurerDetail> getAllInsurerDetail(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			return insuranceClaimServiceImpl.getAllInsurerDetail();

		} else {
			throw new InvalidTokenException();
		}
	}

	/**
	 * Method-GET,
	 * http://localhost:9092/IPTMS/getinsurerbypackagename/IndividualHealthInsurance
	 * 
	 * to get the insurer details based on the insurer package name only after
	 * verifying that the user trying to use this service is authenticated or not
	 * 
	 * @param token
	 * @param insurerPackageName
	 * @return
	 * @throws InvalidTokenException
	 */
	@GetMapping(value = "/getinsurerbypackagename/{insurerPackageName}")
	public InsurerDetail getInsurerDetail(@RequestHeader(name = "Authorization") String token,
			@PathVariable String insurerPackageName) throws InvalidTokenException {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			InsurerDetail insurerDetail = insuranceClaimServiceImpl.getInsurerDetail(insurerPackageName);
			return insurerDetail;
		} else {
			throw new InvalidTokenException();
		}

	}

	/**
	 * Method-POST, http://localhost:9092/iptms/initiateclaim
	 * 
	 * initiates claim for insurance of a patient whose current status is "In
	 * Progress" by providing claim details only after verifying that the user
	 * trying to use this service is authenticated or not
	 * 
	 * @param token
	 * @param initiateClaim
	 * @return
	 */
	@PostMapping(value = "/initiateclaim")
	public double initiateClaim(@RequestHeader(name = "Authorization") String token,
			@RequestBody InitiateClaim initiateClaim) {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			double cost = insuranceClaimServiceImpl.initiateClaim(token, initiateClaim);
			return cost;
		} else {
			throw new InvalidTokenException();
		}
	}

}
