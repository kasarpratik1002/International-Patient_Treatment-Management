package com.cognizant.insurance.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.insurance.model.TreatmentPlan;



/**
*  
* @author Pratik K, Pratik B, Shubham, Kavya
*
*         Feign provides an abstraction over REST-based calls via annotation,
*         by which microservices can communicate with each other without
*         writing detailed REST client code 
*         
*         This Feign Client is used by "iptms-insurance-microservice" 
*         to communicate with "iptms-treatments-microservice" 
*         
*/


@FeignClient(name="iptms-treaments-microservice",url="http://localhost:9091/iptms")
public interface FeignCallService {

	
	/**
	 * Gets the treatment plan of a patient based on patient id. 
	 *
	 * @param patientId
	 * @return
	 */
	@GetMapping("/getplan/{patientId}")
	public TreatmentPlan getPlan(@PathVariable long patientId);
	
	/**
	 * Gets all the treatment plans available for patients
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/getallplans")
	public List<TreatmentPlan> getAllPlans(@RequestHeader(name = "Authorization") String token);
}
