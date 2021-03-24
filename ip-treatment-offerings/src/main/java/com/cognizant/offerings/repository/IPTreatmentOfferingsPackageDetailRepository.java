package com.cognizant.offerings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.offerings.model.IPTreatmentPackage;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		@Repository indicates that the class provides the mechanism for storage,
 * 		retrieval, search, update and delete operation on objects
 *
 */
@Repository
public interface IPTreatmentOfferingsPackageDetailRepository extends JpaRepository<IPTreatmentPackage, Long>{

	/**
	 * query to select treatment package based on ailment category and
	 * package name
	 * 
	 * @param packageName
	 * @param category
	 * @return IPTreatmentPackage
	 */
	@Query(value="select p from IPTreatmentPackage p where p.packageDetail.treatmentPackageName=:packageName and p.ailmentCategory=:category")
	IPTreatmentPackage findByName(@Param("packageName") String packageName, @Param("category")String category);
}
