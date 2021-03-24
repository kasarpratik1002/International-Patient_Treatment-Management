package com.cognizant.offerings.model;

import javax.persistence.Embedded;
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
 * 		model class for IPTreatmentPackage
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
public class IPTreatmentPackage {

	/**
	 * instance variables
	 * 
	 * @Embedded allows for reuse of common mappings between entities
	 * @Id helps in defining the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ailmentCategory;
	
	@Embedded
	PackageDetail packageDetail;
}
