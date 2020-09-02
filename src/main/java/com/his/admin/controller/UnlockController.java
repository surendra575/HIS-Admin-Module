package com.his.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.admin.binding.UnlockAccount;
import com.his.admin.service.HISEmployeeServiceImpl;

@Controller
public class UnlockController {
	
	@Autowired
	private HISEmployeeServiceImpl ser;
	
	@GetMapping("/unlockAcc")
	public String unlockTheAccount(@RequestParam("email") String email,Model model)
	{
		model.addAttribute("email", email);
		UnlockAccount uact=new UnlockAccount();
		model.addAttribute("uac", uact);
		return "uactPage";
	}
	
	@PostMapping("/unlockCheck")
	public String unlockAcctFormHandling(@ModelAttribute("uac") UnlockAccount uac,Model model)
	{
		String actualPwd = ser.findPwdByEmail(uac.getAcctEmail());
		String enteredPwd=uac.getOldPassword();
		System.out.println("email: "+uac.getAcctEmail());
//		System.out.println("Old password: "+uac.getOldPassword());
//		System.out.println("New password: "+uac.getNewPassword());
//		System.out.println("Confirm new password: "+uac.getConfirmNewPassword());
		System.out.println("Actual: "+actualPwd);
		System.out.println("Entered: "+enteredPwd);
		if(!enteredPwd.equals(actualPwd))
		{
			model.addAttribute("pwdEr", "Temporary password mismatch...!!");
			model.addAttribute("email", uac.getAcctEmail());
			return "uactPage";
		}
		else
		{
			int res = ser.updatePwd(uac.getAcctEmail(), uac.getConfirmNewPassword()); 
			if(res==1)
			{
			return "updateSucc";
			}
			else
			{
				return "er";
			}
		}
		
	}

}
