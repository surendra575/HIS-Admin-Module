package com.his.plans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.plans.binding.HIS_Plans;
import com.his.plans.service.HISPlanServiceImpla;

@Controller
public class PlanController {
	@Autowired
	private HISPlanServiceImpla ser;
	
	
	@GetMapping("/plan")
	public String loadPage(Model model)
	{
		HIS_Plans plan=new HIS_Plans();
		model.addAttribute("plan",plan);
		return "plans";
	}
	
	
	@PostMapping("/addPlan")
	public String handlingForm(@ModelAttribute("plan") HIS_Plans plan,RedirectAttributes ra,Model model)
	{
		System.out.println("Details:  "+plan);
		if(plan.getPlanId()==0){
		boolean result = ser.savePlan(plan);
		if(result)
		{
			String msg="Plan Added successfully..!!";
			ra.addFlashAttribute("msg", msg);
		}
		else
		{
			String emsg="Unable to add the plan...!!";
			ra.addFlashAttribute("emsg", emsg);
		}
		
		return "redirect:/plan";
		}
		else
		{
			boolean result = ser.savePlan(plan);
			if(result)
			{
				String msg="Plan Updated successfully..!!";
				ra.addFlashAttribute("msg", msg);
			}
			else
			{
				String emsg="Unable to update the plan...!!";
				ra.addFlashAttribute("emsg", emsg);
			}
			
			return "redirect:/plan";
		}
	}

}
