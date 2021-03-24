package com.cognizant.treatments.exception;


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
		super("the token is expired or wrong");
		
	}

}
