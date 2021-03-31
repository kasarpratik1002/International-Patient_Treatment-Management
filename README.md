# International-Patient_Treatment-Management

***************************************************************************
	1) IP-Treatment Offerings
***************************************************************************
1.POST for generating Token
	URL: http://localhost:8083/auth/login
	{
  	  "userid":"admin1",
    	  "upassword":"admin1"
	}

2.GET IPTreatmentPackages
	URL: http://localhost:9090/iptms/iptreatmentpackages
	Header Key: Authorization
	Value: Bearer token(generated in post(http://localhost:8083/auth/login))

3.GET IPTreatmentPackageByAilmentCategoryAndName
	URL: http://localhost:9090/iptms/iptreatmentpackagebyname/Urology/Package1
	Header Key: Authorization
	Value: Bearer token(generated in post(http://localhost:8083/auth/login))

4.GET Specialists
	URL: http://localhost:9090/iptms/specialists
	Header: Authorization
	Value: Bearer token(generated in post(http://localhost:8083/auth/login))
		
***************************************************************************
	2) IP-Treatment
****************************************************************************************


1.POST for generating Token
	URL: http://localhost:8083/auth/login
	{
  	  "userid":"admin1",
    	  "upassword":"admin1"
	}

2.POST formulateTreatmentTimetable
	URL: http://localhost:9091/iptms/formulatetreatmenttimetable/7000
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))
	JSON: { 
   		"id": 10,
  		"name": "Jack",
   		"age":22,
   		"ailment":"Urology",
 		 "treatmentPackageName": "Package1",
  		 "treatmentCommencementDate": "11/03/2020"
	            }

3.GET getAllPatients
	URL: http://localhost:9091/iptms/getallpatients
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

4.GET allPlans
	URL: http://localhost:9091/iptms/getallplans
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

5.GET AllOnGoingTreatments
	URL: http://localhost:9091/iptms/getallongoingtreatments
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

6.GET getPatient
	URL: http://localhost:9091/iptms/getpatient/1
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

7.GET getAPlan
	URL: http://localhost:9091/iptms/getplan/1
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))
	



*******************************************************************************
	3) Insurance-Claim-Microservice
*******************************************************************************

1. GET All Insurance plans
	URL: http://localhost:9091/iptms/getallplans
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

2. GET InsurerPackageByName 
	URL: http://localhost:9092/iptms/getinsurerbypackagename/Healthcare
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))

3. POST for InitiateClaim
	URL: http://localhost:9092/iptms/initiateclaim
	Header Key: Authorization
	Value: Bearer token (generated in post(http://localhost:8083/auth/login))
	JSON:  {
   		 "id":10,
   		 "patientName":"XYZ",
    		 "ailment":"Urolody",
   		 "treatmentPackageName":"package1",
   		 "insurerName":"SBI Life Insurance"

		}

*********************************************************************************
	4) Authentication
*********************************************************************************
1. POST for generating Token
	URL: http://localhost:8083/auth/login
	{
  	  "userid":"admin1",
    	  "upassword":"admin1"
	}









	


