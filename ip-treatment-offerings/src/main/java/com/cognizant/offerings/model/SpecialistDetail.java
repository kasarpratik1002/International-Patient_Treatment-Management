package com.cognizant.offerings.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for SpecialistDetail
 * 
 * 		@Entity indicates Spring Data JPA that it is an entity class for the
 *      application
 *      @Data is a convenient shortcut annotation that bundles 
 *      the features of @ToString , @EqualsAndHashCode , @Getter / @Setter 
 *      and @RequiredArgsConstructor together
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialistDetail {

	/**
	 * instance variables
	 * 
	 * @Id helps in defining the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;
}
