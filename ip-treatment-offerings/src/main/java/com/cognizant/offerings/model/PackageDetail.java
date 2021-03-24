package com.cognizant.offerings.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for PackageDetail
 * 
 * 		@Entity indicates Spring Data JPA that it is an entity class for the
 *      application
 *      @Data is a convenient shortcut annotation that bundles 
 *      the features of @ToString , @EqualsAndHashCode , @Getter / @Setter 
 *      and @RequiredArgsConstructor together
 *
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDetail {

	/**
	 * instance variables
	 */
	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDurationInWeeks;
}
