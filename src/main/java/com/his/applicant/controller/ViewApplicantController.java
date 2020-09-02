package com.his.applicant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.his.applicant.binding.HIS_Applicant;
import com.his.applicant.entity.HIS_ApplicantEntity;
import com.his.applicant.service.HISApplicantServiceImpl;

@Controller
public class ViewApplicantController {
	@Autowired
	private HISApplicantServiceImpl ser;
	
	@GetMapping("/viewAllApplicants")
	public String allEmps( HttpServletRequest req,Model model)
	{
		Integer currpno=1;
		Integer pageSize=3;
		
		
		String pno = req.getParameter("pno");
		
	
		if(pno!=null && pno!="")
		{
			currpno=Integer.parseInt(pno);
		}
		
		
//		List<HIS_Employee> allEmps = ser.getAllEmps();
		List<HIS_Applicant> allapplicants=new ArrayList<HIS_Applicant>();
		
		Page<HIS_ApplicantEntity> pEntity = ser.getAllApplicants(pageSize, currpno-1);
		List<HIS_ApplicantEntity> empEntities = pEntity.getContent();
		
		
		System.out.println("total number of records"+pEntity.getTotalPages());
		
		long totalPages = pEntity.getTotalPages();
		for(HIS_ApplicantEntity en:empEntities)
		{
			HIS_Applicant ap=new HIS_Applicant();
			BeanUtils.copyProperties(en, ap);
			allapplicants.add(ap);
			
		}
		model.addAttribute("emps", allapplicants);
		model.addAttribute("tp", totalPages);
		model.addAttribute("cpn", currpno);
		return "viewApplicants";
	}
	
	
	
//	@GetMapping(value="/delete/{eid}")
//	public String deleteEmp(@PathVariable int eid,Model model)
//	{
//		int res = ser.deleteEmployee(eid);
//		
//		
//		if(res==1) {
//		
//		return "redirect:/viewAllEmployees";}
//		else
//		{
//			return null;
//		}
//	}
//	
//	@GetMapping(value="/activate/{eid}")
//	public String activateEmp(@PathVariable int eid,Model model)
//	{
//		int res = ser.activateEmployee(eid);
//		
//		
//		if(res==1) {
//		
//		return "redirect:/viewAllEmployees";}
//		else
//		{
//			return null;
//		}
//	}
//	
//	
//	@GetMapping(value="/edit/{eid}") 
//	public String editContact(@PathVariable int eid, Model model) {
//		
//		HIS_Employee hisEmp = ser.getEmployeeById(eid);
//		//HIS_Employee con = ser.getContactById(eid);
//		model.addAttribute("hem", hisEmp);
//		
//		Map<Integer,String> roles=ser.getAllRoles();
//		model.addAttribute("roles", roles);
//		
//		return "registration";
//	}

}
