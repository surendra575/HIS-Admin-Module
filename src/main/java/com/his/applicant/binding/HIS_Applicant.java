package com.his.applicant.binding;

import lombok.Data;

@Data
public class HIS_Applicant {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Long phoneNumber;
	private String ssnNumber;
	private String dob;

}
