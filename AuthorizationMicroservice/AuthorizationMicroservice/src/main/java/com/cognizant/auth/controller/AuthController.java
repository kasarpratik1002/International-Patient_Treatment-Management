package com.cognizant.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auth.model.Admin;
import com.cognizant.auth.model.AuthResponse;
import com.cognizant.auth.repository.UserRepository;
import com.cognizant.auth.service.CustomerDetailsService;
import com.cognizant.auth.service.JwtUtil;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 *
 * 		@RestController  a special controller used in RESTFul web services and 
 * 		the equivalent of @Controller and @ResponseBody
 * 		
 *		
 */
@RestController

public class AuthController {

	
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService customerDetailservice;
	@Autowired
	private UserRepository userRepository;


	/**
	 * Method-POST, http://localhost:8083/login
	 * 
	 * to allow login of a user only after verifying
	 * that the user trying to use this service is authenticated or not
	 * 
	 * @param userlogincredentials
	 * @return
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Admin userlogincredentials) {
		final UserDetails userdetails = customerDetailservice.loadUserByUsername(userlogincredentials.getUserid());
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			return new ResponseEntity<>(
					new Admin(userlogincredentials.getUserid(), null, null, jwtutil.generateToken(userdetails)),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid Username or Password", HttpStatus.FORBIDDEN);
		}
	}

	/**
	 * Method-GET, http://localhost:8083/validate
	 * 
	 * to set the validity of a user if the token provided
	 * to the application is correct.
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
			res.setName((userRepository.findById(jwtutil.extractUsername(token)).orElse(null).getUname()));

		} else
			res.setValid(false);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}