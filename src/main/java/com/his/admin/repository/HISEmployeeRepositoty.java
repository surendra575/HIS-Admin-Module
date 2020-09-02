package com.his.admin.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.admin.entity.HIS_EmployeeEntity;

public interface HISEmployeeRepositoty extends JpaRepository<HIS_EmployeeEntity, Serializable>{
	@Query("select password from HIS_EmployeeEntity where email=:email")
	public String getPwdByEmail(String email);
	
	public HIS_EmployeeEntity findByEmail(String email);
	
	public HIS_EmployeeEntity findByEmailAndPassword(String email,String password);
	
	
	
	@Query("select deleteSwitch from HIS_EmployeeEntity where email=:email")
	public String getDeleteSwitch(String email);
	
	@Query("select role from HIS_EmployeeEntity where email=:email")
	public String getRole(String email);
	
	@Query("select acct_status from HIS_EmployeeEntity where email=:email")
	public String getAcctStatus(String email);
	
	
	@Transactional
	@Modifying
	@Query("update HIS_EmployeeEntity u set u.password=:pwd,u.acct_status=:status where u.email=:email")
	public Integer updatePazzword(String email,String pwd,String status);
	
	@Transactional
	@Modifying
	@Query("update HIS_EmployeeEntity u set u.deleteSwitch=:msg where u.eid=:eid")
	                                        
	public Integer softDeleteEmployee(int eid,String msg);
	
	@Transactional
	@Modifying
	@Query("update HIS_EmployeeEntity u set u.deleteSwitch=:msg where u.eid=:eid")
	                                        
	public Integer softActivateEmployee(int eid,String msg);
	
	
	 
	
	

}
