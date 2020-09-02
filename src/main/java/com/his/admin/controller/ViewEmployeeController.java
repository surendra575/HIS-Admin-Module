package com.his.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.his.admin.binding.HIS_Employee;
import com.his.admin.entity.HIS_EmployeeEntity;
import com.his.admin.service.HISEmployeeServiceImpl;

@Controller
public class ViewEmployeeController {
	@Autowired
	private HISEmployeeServiceImpl ser;
	
	@GetMapping("/viewAllEmployees")
	public String allEmps( HttpServletRequest req,Model model)
	{
		Integer currpno=1;
		Integer pageSize=10;
		String role="CASE-WORKER";
		
		String pno = req.getParameter("pno");
		String rle = req.getParameter("role");
		System.out.println("Role from UI is: "+rle);
		if(pno!=null && pno!="")
		{
			currpno=Integer.parseInt(pno);
		}
		if(rle!=null && rle!="")
		{
			role=rle;
		}
		
//		List<HIS_Employee> allEmps = ser.getAllEmps();
		List<HIS_Employee> allEmps=new ArrayList<HIS_Employee>();
		
		Page<HIS_EmployeeEntity> pEntity = ser.getAllEmps(pageSize, currpno-1,role);
		List<HIS_EmployeeEntity> empEntities = pEntity.getContent();
		
		
		System.out.println("total number of records"+pEntity.getTotalPages());
		
		long totalPages = pEntity.getTotalPages();
		for(HIS_EmployeeEntity en:empEntities)
		{
			HIS_Employee emp=new HIS_Employee();
			emp.setEid(en.getEid());
			emp.setFirstName(en.getFirstName());
			emp.setLastName(en.getLastName());
			emp.setEmail(en.getEmail());
			emp.setGender(en.getGender());
			emp.setRole(en.getRole());
			emp.setAcct_status(en.getAcct_status());
			emp.setDeleteSwitch(en.getDeleteSwitch());
			allEmps.add(emp);
			
		}
		model.addAttribute("emps", allEmps);
		model.addAttribute("tp", totalPages);
		model.addAttribute("cpn", currpno);
		return "viewEmps";
	}
	
	
	
	@GetMapping(value="/delete/{eid}")
	public String deleteEmp(@PathVariable int eid,Model model)
	{
		int res = ser.deleteEmployee(eid);
		
		
		if(res==1) {
		
		return "redirect:/viewAllEmployees";}
		else
		{
			return null;
		}
	}
	
	@GetMapping(value="/activate/{eid}")
	public String activateEmp(@PathVariable int eid,Model model)
	{
		int res = ser.activateEmployee(eid);
		
		
		if(res==1) {
		
		return "redirect:/viewAllEmployees";}
		else
		{
			return null;
		}
	}
	
	
	@GetMapping(value="/edit/{eid}") 
	public String editContact(@PathVariable int eid, Model model) {
		
		HIS_Employee hisEmp = ser.getEmployeeById(eid);
		//HIS_Employee con = ser.getContactById(eid);
		model.addAttribute("hem", hisEmp);
		
		Map<Integer,String> roles=ser.getAllRoles();
		model.addAttribute("roles", roles);
		
		return "registration";
	}

}
