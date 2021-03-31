package com.cognizant.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 *         Service Class For Various Web-Portal functionalities
 * 
 * 
 * @Service Indicates that an annotated class is a "Service", originally defined
 *          by Domain-DrivenDesign (Evans, 2003) as "an operation offered as an
 *          interface that stands alone in the model, with no encapsulated
 *          state."
 */

@Service
public class PortalService {

	@SuppressWarnings("unused")
	private static final InitiateClaim InitiateClaim = null;
	/**
	 * autowires the IPTFClient(IP-treatments-Microservice feign client) to
	 * communicate with authorization
	 *
	 */
	@Autowired
	IPTFClient iPTFClient;
	/**
	 * autowires the IPTFOClient(IP-treatment-Offernings feign client) to
	 * communicate with authorization
	 *
	 */

	@Autowired
	IPTOFClient iPTFOClient;
	/**
	 * autowires the ICClient(Insurance-Claim-Microservice feign client) to
	 * communicate with authorization
	 *
	 */
	@Autowired
	ICClient iCClient;

	/**
	 * 
	 * this method will return the List of Specialist Available in the Hospital.
	 * 
	 * @param token
	 * @return List<SpecialistDetail>
	 * 
	 */
	public List<SpecialistDetail> getSpecialistDetail(String token) {
		List<SpecialistDetail> specialistDetail = iPTFOClient.getSpecialists(token).getBody();
		return specialistDetail;
	}

	/**
	 * 
	 * this method will return the List of Available Insurers in the Hospital.
	 * 
	 * @param token
	 * @return List<InsurerDetail>
	 * 
	 */
	public List<InsurerDetail> getInsurerDetail(String token) {
		List<InsurerDetail> insurerDetail = iCClient.getAllInsurerDetail(token);
		return insurerDetail;
	}

	/**
	 * 
	 * this method will return the Treatment Plan of a Patient
	 * 
	 * @param token
	 * @param PatientDetail Object
	 * @param Cost
	 * @return TreatmentPlan Object
	 * 
	 */
	public TreatmentPlan registerPatient(String token, PatientDetail patient, int cost) {
		TreatmentPlan treatmentPlan = iPTFClient.formulateTreatmentTimetable(token, patient, cost);
		return treatmentPlan;
	}

	/**
	 * 
	 * this method will return the List of Treatment Packages Available in the
	 * Hospital.
	 * 
	 * @param token
	 * @return List<IPTreatmentPackage>
	 * 
	 */
	public List<IPTreatmentPackage> getPackageDetail(String token) {
		@SuppressWarnings("unchecked")
		List<IPTreatmentPackage> packageDetail = (List<IPTreatmentPackage>) iPTFOClient.getIPTreatmentPackages(token)
				.getBody();
		return packageDetail;
	}

	/**
	 * 
	 * this method will return the List of ALL Treatments in the Hospital.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 * 
	 */

	public List<TreatmentPlan> getTreatmentPlanList(String token) {
		List<TreatmentPlan> treatmentPlan = iPTFClient.getAllPatients(token);
		return treatmentPlan;
	}

	/**
	 * 
	 * this method will return the List of On Going Treatments in the Hospital.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 * 
	 */

	public List<TreatmentPlan> getOnGoingTreatmentPlanList(String token) {
		List<TreatmentPlan> treatmentPlan = iPTFClient.getAllOnGoingTreatments(token);
		return treatmentPlan;
	}

	/**
	 * 
	 * this method will return the List of Available Insurers in the Hospital.
	 * 
	 * @param token
	 * @return List<InsurerDetail>
	 * 
	 */
	public List<InsurerDetail> claimInsurance(String token) {
		List<InsurerDetail> insurerDetail = iCClient.getAllInsurerDetail(token);
		return insurerDetail;
	}

	/**
	 * 
	 * this method will return the Particular Insurance Provider selected for a
	 * patient.
	 * 
	 * @param token
	 * @param packageName
	 * @return InsurerDetail Object
	 * 
	 */
	public InsurerDetail getInsurerDetail(String packageName, String token) {
		InsurerDetail insurerDetail = iCClient.getInsurerDetail(packageName, token);
		return insurerDetail;
	}

	/**
	 * 
	 * this method will return the Particular Patient based on patient ID.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public PatientDetail getPatientDetail(long ptId, String token) {
		PatientDetail patientDetail = iPTFClient.getPatient(ptId, token);
		return patientDetail;
	}

	/**
	 * 
	 * this method will return the Treatment Plan of a Particular Patient.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public TreatmentPlan getTreatmentDetail(long ptId, String token) {
		TreatmentPlan treatmentPlan = iPTFClient.getAPlan(ptId, token);
		return treatmentPlan;
	}

	/**
	 * 
	 * this method will return the Remaining Amount to be paid after claim
	 * Settlement.
	 * 
	 * @param token
	 * @param InitiateClaim Object
	 * @return List<InsurerDetail>
	 * 
	 */
	public int initiateClaim(String token, InitiateClaim initiateClaim) {
		int amt = iCClient.initiateClaim(token, initiateClaim);
		return amt;
	}

	/**
	 * 
	 * this method will Update Patient Status from On Progress to Complete.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public void updatePlan(long ptId, String token) {
		iPTFClient.updatePlan(ptId, token);
	}

	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		return headers.getFirst("Authorization");
	}

}
