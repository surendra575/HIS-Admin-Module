package com.his.admin.controller;

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
public class ForgotController {
	@Autowired
	private HISEmployeeServiceImpl ser;
	
	@GetMapping("/forgot")
	public String loadForgotPwdPage(Model model)
	{
		HIS_Employee u=new HIS_Employee();
		model.addAttribute("user", u);
		return "forgotPwd";
	}
	
	@PostMapping("/forgotpwd")
	public String handlingForgotPwd(@ModelAttribute("user") HIS_Employee user,Model model,RedirectAttributes ra) {
		boolean res = ser.checkEmail(user.getEmail());
		
		if(res)
		{
			boolean msgRes=ser.sendPazzwordToMobile(user.getEmail());
			Long ph=ser.getPhoneNumberByEmail(user.getEmail());
			String phone=ph.toString().substring(7,10);
			if(msgRes)
			{
				model.addAttribute("ms", "Your password has been successfully send to *******"+phone);
				return "frgtSuccess";
			}
			else
			{
				ra.addFlashAttribute("er", "Unable to send your password...!!!");
				return "redirect:/forgot";
			}
			
		}
		else
		{
			ra.addFlashAttribute("er", "Invalid email id...!!!");
			return "redirect:/forgot";
		}
		
	}

}
