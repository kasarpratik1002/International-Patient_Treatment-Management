package com.cognizant.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.auth.model.Admin;
import com.cognizant.auth.repository.UserRepository;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 *         service class that implements the interface UserDetailsService that
 *         includes user details method definitions
 * 
 * 
 *
 */
@Service

public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Locates the user based on the username returns the core user information
	 */
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		Admin custuser = userRepository.findById(uid).orElse(null);
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
	}

}
