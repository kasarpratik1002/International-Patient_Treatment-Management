package com.cognizant.insurance.exception;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 * 		custom based exception class for InvalidTokenException
 *
 */
public class InvalidTokenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super("the token is expired or wrong");
		
	}

}
