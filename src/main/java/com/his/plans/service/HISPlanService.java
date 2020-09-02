package com.his.plans.service;

import org.springframework.data.domain.Page;

import com.his.plans.binding.HIS_Plans;
import com.his.plans.entity.HIS_PlansEntity;

public interface HISPlanService {
public boolean savePlan(HIS_Plans plan);
	
	//public List<HIS_Plans> getAllPlans();
	
	public Page<HIS_PlansEntity> getAllPlans(Integer pageSize,Integer pageNo);
	
	public int deletePlan(int planId);
	
	public int activatePlan(int planId);
	
	public HIS_Plans getPlanById(int planId);

}
