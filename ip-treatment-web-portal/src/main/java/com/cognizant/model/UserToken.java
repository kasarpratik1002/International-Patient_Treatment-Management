package com.cognizant.model;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for User Token
 * 
 *  
 */
public class UserToken {
	private String uid;
	private String authToken;

	public UserToken(String uid, String authToken) {
		super();
		this.uid = uid;
		this.authToken = authToken;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public UserToken() {
		super();
	}
}
