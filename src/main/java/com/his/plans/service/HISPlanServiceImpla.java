package com.his.plans.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.his.plans.binding.HIS_Plans;
import com.his.plans.entity.HIS_PlansEntity;
import com.his.plans.repository.HIS_PlanRepository;
@Service
public class HISPlanServiceImpla implements HISPlanService {
	@Autowired
	private HIS_PlanRepository planRepo;

	@Override
	public boolean savePlan(HIS_Plans plan) {
		
		HIS_PlansEntity planEntity=new HIS_PlansEntity();
		
		BeanUtils.copyProperties(plan, planEntity);
		
		planEntity.setActiveSwitch("YES");
		
		HIS_PlansEntity res = planRepo.save(planEntity);
		if(res!=null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public Page<HIS_PlansEntity> getAllPlans(Integer pageSize,Integer pageNo) {
		
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<HIS_PlansEntity> fAll = planRepo.findAll(page);
		return fAll;
	}

	@Override
	public int deletePlan(int planId) {
		String msg="NO";
		Integer del = planRepo.softDeletePlan(planId, msg);
		return del;
	}


	@Override
	public int activatePlan(int planId) {
		String msg="YES";
		Integer act = planRepo.softActivatePlan(planId, msg);
		return act;
	}


	@Override
	public HIS_Plans getPlanById(int planId) {
		Optional<HIS_PlansEntity> re =planRepo.findById(planId);
		
		
		if(re.isPresent())
		{
			HIS_PlansEntity ent = re.get();
			HIS_Plans plan=new HIS_Plans();
			
			BeanUtils.copyProperties(ent, plan);
			
			return plan;
			
		}
		
		return null;
	}

}
