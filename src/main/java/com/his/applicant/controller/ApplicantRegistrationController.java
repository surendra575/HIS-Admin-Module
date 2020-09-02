package com.his.applicant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.applicant.binding.HIS_Applicant;
import com.his.applicant.service.HISApplicantServiceImpl;

@Controller
public class ApplicantRegistrationController {
	@Autowired
	private HISApplicantServiceImpl ser;

	@GetMapping("/regApplicant")
	public String loadingRegPage(Model model) {
		HIS_Applicant hemp = new HIS_Applicant();
		model.addAttribute("hem", hemp);


		return "applicantReg";
	}

	@PostMapping("/addApplicant")
	public String handlingFormData(@ModelAttribute("hemp") HIS_Applicant hemp, RedirectAttributes ra, Model model) {
		System.out.println("ID: "+hemp.getId());	
		
		String state="oklahoma";
		
		boolean ssnStatus = ser.checkSSNNumber(hemp.getSsnNumber(), state);
		if(ssnStatus){
		
		if (hemp.getId() == null || hemp.getId()==0) {
			

			boolean res = ser.registerApplicant(hemp);
			if (res) {
				String msg="Applicant added successfully....";
				ra.addFlashAttribute("msg",msg);
				
			} else {
				String emsg="Something went wrong..!!!!!!!!";
				ra.addFlashAttribute("emsg",emsg);
				
			}
			return  "redirect:/regApplicant";
			
			}
		else {
			System.out.println("ID from AppRegController : "+hemp.getId());
			boolean res = ser.registerApplicant(hemp);
			
			if (res) {
				String msg="Applicant record updated successfully....";
				ra.addFlashAttribute("msg",msg);
				
			} else {
				String emsg="Unable to update the applicant..!!!!!!!!";
				ra.addFlashAttribute("emsg",emsg);
				
			}
			return  "redirect:/regApplicant";
		}
		}
		else
		{
			String ssnEr="Invalid SSN number or Your ssn not belongs to Ooklahoma..!!!!!!!!";
			ra.addFlashAttribute("ssnEr",ssnEr);
			return  "redirect:/regApplicant";
		}
	}

}
