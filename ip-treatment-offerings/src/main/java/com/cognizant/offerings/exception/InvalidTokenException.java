package com.cognizant.offerings.exception;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
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
		super("The token is expired or wrong");
		
	}

}
