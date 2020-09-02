package com.his.plans.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.his.plans.binding.HIS_Plans;
import com.his.plans.entity.HIS_PlansEntity;
import com.his.plans.service.HISPlanServiceImpla;

@Controller
public class ViewPlansController {
	@Autowired
	private HISPlanServiceImpla ser;
	
	@GetMapping("/viewAllPlans")
	public String allPlans(HttpServletRequest req,Model model)
	{
		Integer currpno=1;
		Integer pageSize=3;
		
		String pno = req.getParameter("pno");
		if(pno!=null && pno!="")
		{
			currpno=Integer.parseInt(pno);
		}
		Page<HIS_PlansEntity> pageData = ser.getAllPlans(pageSize, currpno-1);
		List<HIS_PlansEntity> entity = pageData.getContent();
		int totalPages = pageData.getTotalPages();
		
		List<HIS_Plans> allPlans=new ArrayList<HIS_Plans>();
		for(HIS_PlansEntity hp:entity)
		{
			HIS_Plans hplan=new HIS_Plans();
			BeanUtils.copyProperties(hp, hplan);
			allPlans.add(hplan);
		}
		model.addAttribute("plans", allPlans);
		model.addAttribute("tp", totalPages);
		model.addAttribute("cpn", currpno);
		return "viewplans";
//		List<HIS_Plans> allPlans = ser.getAllPlans();
//		model.addAttribute("plans", allPlans);
//		return "viewplans";
	}
	
	
	
	
	
	@GetMapping(value="/activatePlan/{planId}")
	public String activatePlan(@PathVariable int planId,Model model)
	{
		int res = ser.activatePlan(planId);
		
		
		if(res==1) {
		
		return "redirect:/viewAllPlans";}
		else
		{
			return null;
		}
	}
	
	
	@GetMapping(value="/deletePlan/{planId}")
	public String deletePlan(@PathVariable int planId,Model model)
	{
		int res = ser.deletePlan(planId);
		
		
		if(res==1) {
		
		return "redirect:/viewAllPlans";}
		else
		{
			return null;
		}
	}
	
	
	@GetMapping(value="/editPlan/{planId}") 
	public String editContact(@PathVariable int planId, Model model) {
		
		HIS_Plans plan = ser.getPlanById(planId);
		//HIS_Employee con = ser.getContactById(eid);
		model.addAttribute("plan", plan);
		
		
		
		return "plans";
	}

}
