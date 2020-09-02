package com.his.admin.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.his.admin.binding.HIS_Employee;
import com.his.admin.entity.HIS_EmployeeEntity;



public interface HISEmployeeService { 
	
	public boolean registerEmployee(HIS_Employee his);
	
	public Map<Integer,String> getAllRoles();
	
	public String findPwdByEmail(String email);
	
	public int updatePwd(String email,String pwd);
	//public List<HIS_Employee> getAllEmps();
	
	public boolean checkCredentials(String email,String pwd);
	public boolean checkAcctStatus(String email);
	public boolean checkEmail(String email);
	
	public Page<HIS_EmployeeEntity> getAllEmps(Integer pageSize,Integer pageNo,String role);
	
	public int deleteEmployee(int eid);
	
	public int activateEmployee(int eid);
	
	public boolean checkEmailForLogin(String email);
	
	public HIS_Employee getEmployeeById(int eid);
	
	
	
	public String findRole(String email);
	
	public boolean findDeleteSwithValue(String email);
	
	public boolean sendPazzwordToMobile(String email);
	public Long getPhoneNumberByEmail(String email);

}
