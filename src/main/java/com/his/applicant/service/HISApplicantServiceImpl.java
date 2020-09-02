package com.his.applicant.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.his.applicant.binding.HIS_Applicant;
import com.his.applicant.entity.HIS_ApplicantEntity;
import com.his.applicant.repository.HIS_ApplicantRepository;

@Service
public class HISApplicantServiceImpl implements HISApplicantService {
	
	@Autowired
	private HIS_ApplicantRepository applicantRepo;

	@Override
	public boolean registerApplicant(HIS_Applicant applicant) {
		HIS_ApplicantEntity entity=new HIS_ApplicantEntity();
		BeanUtils.copyProperties(applicant,entity);
		
		HIS_ApplicantEntity en = applicantRepo.save(entity);
		if(en.getFirstName()!=null)
		{
			return true;
		}
		else{
		return false;
		}
	}

	@Override
	public Page<HIS_ApplicantEntity> getAllApplicants(Integer pageSize,Integer pageNo) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		System.out.println("****came to service class*********");
		Page<HIS_ApplicantEntity> findAll = applicantRepo.findAll(page);
		return findAll;
	}
	
	@Override
	public boolean checkSSNNumber(String ssn, String stateName) {
		   String url = "http://localhost:8020/checkSSN/{ssn}/{state}";
		   WebClient wc = WebClient.create();
		   String res = wc.get()
		   .uri(url, ssn,stateName)
		   .retrieve()
		   .bodyToMono(String.class)
		   .block();
		   System.out.println("Result from SSN is: "+res);
		   if(res.equals("VALID"))
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
		
	}

}
