package com.cognizant.treatments.model;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for authorization response
 * 
 *     
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	
	/**
	 * instance variables
	 */
	
	private String uid;
	private String name;
	private boolean isValid;
}
