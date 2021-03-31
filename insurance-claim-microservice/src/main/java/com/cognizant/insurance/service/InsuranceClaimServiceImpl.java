package com.cognizant.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.insurance.client.AuthClient;
import com.cognizant.insurance.client.FeignCallService;
import com.cognizant.insurance.exception.InsurerDetailNotFoundException;
import com.cognizant.insurance.exception.InvalidTokenException;
import com.cognizant.insurance.model.AuthResponse;
import com.cognizant.insurance.model.InitiateClaim;
import com.cognizant.insurance.model.InsurerDetail;
import com.cognizant.insurance.model.TreatmentPlan;
import com.cognizant.insurance.repository.InitiateClaimRepository;
import com.cognizant.insurance.repository.InsurerDetailRepository;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 *         service class that implements the interface InsuranceClaimService
 *         that includes business logic method definitions
 *
 */

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 * microservice
	 * 
	 * autowires the FeignCallService autowires the InsuranceClaimService autowires
	 * the InsurerDetailRepository and InitiateClaimRepository
	 */
	@Autowired
	AuthClient authClient;

	@Autowired
	private FeignCallService loadBalancer;

	@Autowired
	InsurerDetailRepository insurerDetailRepository;

	@Autowired
	InitiateClaimRepository initiateClaimRepository;

	/**
	 * to return the list of all insurers
	 * 
	 * @return List<InsurerDetail>
	 */
	@Override
	public List<InsurerDetail> getAllInsurerDetail() {
		List<InsurerDetail> insurerDetailList = null;
		try {
			insurerDetailList = insurerDetailRepository.findAll();
		} catch (Exception e) {
			throw new InsurerDetailNotFoundException();
		}
		return insurerDetailList;
	}

	/**
	 * to return the details of an insurer based on the insurer package name
	 * 
	 * @return InsurerDetail
	 */
	@Override
	public InsurerDetail getInsurerDetail(String insurerPackageName) {
		long packageId = 0;
		InsurerDetail insurerDetail = null;
		List<InsurerDetail> allInsureres = insurerDetailRepository.findAll();
		for (InsurerDetail insurer : allInsureres) {
			if (insurer.getInsurerPackageName().equalsIgnoreCase(insurerPackageName)) {
				packageId = insurer.getId();
				break;
			}
		}
		insurerDetail = insurerDetailRepository.findById(packageId)
				.orElseThrow(() -> new InsurerDetailNotFoundException(
						"Insurer details not found with insurer package name :" + insurerPackageName));
		return insurerDetail;
	}

	/**
	 * to initiate insurance claim for a patient "In Progress" and return the
	 * outstanding amount that the patient need to pay
	 * 
	 * @return outstanding amount
	 */
	@Override
	public double initiateClaim(@RequestHeader(name = "Authorization") String token, InitiateClaim initiateClaim) {
		String insurerName = initiateClaim.getInsurerName();
		double insuranceAmountLimit = 0;
		List<InsurerDetail> allInsurers = insurerDetailRepository.findAll();
		for (InsurerDetail insurerDetail : allInsurers) {
			if (insurerDetail.getInsurerName().equalsIgnoreCase(insurerName)) {
				insuranceAmountLimit = insurerDetail.getInsuranceAmountLimit();
			}
		}
		double treatmentCost = 0;
		String treatmentPackageName = initiateClaim.getTreatmentPackageName();
		List<TreatmentPlan> allTreatmentPlans = loadBalancer.getAllPlans(token);
		for (TreatmentPlan treatmentPlan : allTreatmentPlans) {
			if (treatmentPlan.getPackageName().equalsIgnoreCase(treatmentPackageName)) {
				treatmentCost = treatmentPlan.getCost();
			}
		}
		double cost = treatmentCost - insuranceAmountLimit;
		initiateClaimRepository.save(initiateClaim);
		return cost;
	}

	/**
	 * to validate the token
	 * 
	 * @param token
	 * @return AuthResponse
	 */
	public AuthResponse validateToken(String token) {

		AuthResponse authResponse = null;
		try {
			authResponse = authClient.verifyToken(token);
			if (!authResponse.isValid()) {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			throw new InvalidTokenException();
		}

		return authResponse;
	}

}
