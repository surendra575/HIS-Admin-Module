package com.his.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.admin.binding.HIS_Employee;
import com.his.admin.service.HISEmployeeServiceImpl;

@Controller
public class EmpRegController {
	@Autowired
	private HISEmployeeServiceImpl ser;

	@GetMapping("/register")
	public String loadingRegPage(Model model) {
		HIS_Employee hemp = new HIS_Employee();
		model.addAttribute("hem", hemp);

		Map<Integer, String> roles = ser.getAllRoles();
		model.addAttribute("roles", roles);

		return "registration";
	}

	@PostMapping("/addEmployee")
	public String handlingFormData(@ModelAttribute("hemp") HIS_Employee hemp, RedirectAttributes ra, Model model) {
		System.out.println("EID: "+hemp.getEid());	
		
		if (hemp.getEid() == null || hemp.getEid()==0) {
			

			boolean res = ser.registerEmployee(hemp);
			if (res) {
				String msg="Employee added successfully....";
				ra.addFlashAttribute("msg",msg);
				
			} else {
				String emsg="Something went wrong..!!!!!!!!";
				ra.addFlashAttribute("emsg",emsg);
				
			}
			return  "redirect:/register";
			
			}
		else {
			System.out.println("EID from EmpRegController : "+hemp.getEid());
			boolean res = ser.registerEmployee(hemp);
			
			if (res) {
				String msg="Employee record updated successfully....";
				ra.addFlashAttribute("msg",msg);
				
			} else {
				String emsg="Unable to update the..!!!!!!!!";
				ra.addFlashAttribute("emsg",emsg);
				
			}
			return  "redirect:/register";
		}
	}

}
