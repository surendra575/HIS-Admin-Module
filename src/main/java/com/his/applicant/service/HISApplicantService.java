package com.his.applicant.service;

import org.springframework.data.domain.Page;

import com.his.applicant.binding.HIS_Applicant;
import com.his.applicant.entity.HIS_ApplicantEntity;

public interface HISApplicantService {
	public boolean registerApplicant(HIS_Applicant applicant);
	
	public Page<HIS_ApplicantEntity> getAllApplicants(Integer pageSize,Integer pageNo);
	
	public boolean checkSSNNumber(String ssn,String stateName);

}
