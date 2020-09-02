package com.his.plans.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.plans.entity.HIS_PlansEntity;

public interface HIS_PlanRepository extends JpaRepository<HIS_PlansEntity, Serializable> {
	@Transactional
	@Modifying
	@Query("update HIS_PlansEntity u set u.activeSwitch=:msg where u.planId=:planId")
	                                        
	public Integer softDeletePlan(int planId,String msg);
	
	@Transactional
	@Modifying
	@Query("update HIS_PlansEntity u set u.activeSwitch=:msg where u.planId=:planId")
	                                        
	public Integer softActivatePlan(int planId,String msg);
	
	

}
