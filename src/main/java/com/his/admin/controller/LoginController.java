package com.his.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.his.admin.binding.Login;
import com.his.admin.service.HISEmployeeServiceImpl;

@Controller
public class LoginController {
	
	Logger logger=LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private HISEmployeeServiceImpl ser;
	
	@GetMapping("/home")
	
	public String loadLoginPage(Model model)
	{
		Login l=new Login();
		model.addAttribute("login", l);
		return "home";
	}
	

	@PostMapping("/login")
	public String progilePage(@ModelAttribute("login") Login login, Model model) {
		logger.debug("******profilePage method execution started******");
		System.out.println("Entered email: "+login.getEmail()+" ,Password: "+login.getPassword());
		String page = "";
		try {
		boolean emailAvail = ser.checkEmail(login.getEmail());
		
		
		//int a=10/0;
		if (emailAvail) {
			logger.info("******emailId valid********");
			boolean res = ser.checkCredentials(login.getEmail(), login.getPassword());
			boolean sts = ser.checkAcctStatus(login.getEmail());
			boolean del_sw = ser.findDeleteSwithValue(login.getEmail());
			String role = ser.findRole(login.getEmail());

			System.out.println("credentials: " + res + " status: " + sts);

			if (res && sts && del_sw) {
				if(role.equals("ADMIN"))
				{
					logger.info("******both credentials,status unlocked, Admin logged in********");
					model.addAttribute("msg", "Welcome to Mr.Admin...your profile page is under construction...");
					page="adminPage";
				}
				else if(role.equals("CASE-WORKER"))
				{
					logger.info("******both credentials,status unlocked, Case-worker logged in********");
					model.addAttribute("msg", "Welcome to Mr.Case worker...your profile page is under construction...");
					page="cwPage";
				}
				
				
			} else if (!res) {
				logger.info("******invalid credentials********");
				model.addAttribute("er", "Invalid credentials..!!");
				page = "home";
			} else if (!sts) {
				logger.info("******status is locked********");
				model.addAttribute("er", "Your account was locked...");
				page = "home";
			}
			else if (!del_sw) {
				logger.info("******deleteSwitch  is On********");
				model.addAttribute("er", "Your account was deleted by Admin...kindly reach out to Admin...");
				page = "home";
			}
			
		} else {
			logger.info("******emailId not valid********");
			model.addAttribute("er", "Invalid email ID....!!!");
			page = "home";
		}
		
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			page="er";
			//throw new RegistrationException("Login functionality failed");
		}
		logger.debug("******profilePage method execution ended******");
		return page;
	}

}
