package com.cognizant.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for Patient Details
 * 
 *     
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetail {

	private long id;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackageName;
	private String treatmentCommencementDate;
}
