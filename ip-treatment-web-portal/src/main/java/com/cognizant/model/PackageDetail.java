package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		model class for Package Details
 * 
 *      @Data is a convenient shortcut annotation that bundles 
 *      the features of @ToString , @EqualsAndHashCode , @Getter / @Setter 
 *      and @RequiredArgsConstructor together
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PackageDetail {


private String treatmentPackageName;
private String testDetail;
private int cost;
private int treatmentDurationinWeeks;
@Override
public String toString() {
	return "PackageDetail [treatmentPackageName=" + treatmentPackageName + ", testDetail=" + testDetail + ", cost="
			+ cost + ", treatmentDurationinWeeks=" + treatmentDurationinWeeks + "]";
}

}