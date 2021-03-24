package com.cognizant.insurance.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 * 		model class for PatientDetail which is 
 * 		a model class in ip-treatments-microservice but is
 * 	    used by insurance-claim-microservice
 * 		using Feign Client
 * 
 *      @Data is a convenient shortcut annotation that bundles 
 *      the features of @ToString , @EqualsAndHashCode , @Getter / @Setter 
 *      and @RequiredArgsConstructor together
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetail {

	/**
	 * instance variables
	 * 
	 * @Id helps in defining the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackageName;
	private String treatmentCommencementDate;

}
