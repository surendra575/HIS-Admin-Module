package com.his.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.his.admin.binding.HIS_Employee;
import com.his.admin.entity.HIS_EmployeeEntity;
import com.his.admin.entity.HIS_RolesEntity;
import com.his.admin.repository.EmpByRoleRepo;
import com.his.admin.repository.HISEmployeeRepositoty;
import com.his.admin.repository.HISRolesRepository;
import com.his.admin.utility.EmailUtility;
import com.his.admin.utility.ForgotPwdUtility;
import com.his.admin.utility.PwdUtility;
import com.his.constants.AppConstants;
@Service
public class HISEmployeeServiceImpl implements HISEmployeeService {
	@Autowired
	private HISEmployeeRepositoty empRepo;
	
	@Autowired
	private EmpByRoleRepo erepo;
	
	@Autowired
	private HISRolesRepository rolesRepo;
	
	@Autowired
	private PwdUtility pwdUtility;
	
	@Autowired
	private EmailUtility eu;
	
	
	@Autowired
	private ForgotPwdUtility fpu;

	
	@Override
	public Map<Integer,String> getAllRoles() {
		Map<Integer,String> rolesList=new HashMap<>();
		List<HIS_RolesEntity> allRoles = rolesRepo.findAll();
		
		for(HIS_RolesEntity he:allRoles)
		{
			rolesList.put(he.getRoleId(), he.getRoleName());

		}		        
		return rolesList;
	}


	@Override
	public boolean registerEmployee(HIS_Employee his) {
		
		String tempPwd=pwdUtility.generatePassword();
		his.setPassword(tempPwd);
		if(Integer.parseInt(his.getRole())==1)
		{
			his.setRole("CASE-WORKER");
		}
		else
		{
			his.setRole("ADMIN");
		}
		his.setAcct_status("LOCKED");
		his.setDeleteSwitch("NO");
		
		HIS_EmployeeEntity hentity=new HIS_EmployeeEntity();
		
		System.out.println("EID from service : "+his.getEid()+" -->entity ID: "+hentity.getEid());
		
//		hentity.setEid(his.getEid());
//		hentity.setFirstName(his.getFirstName());
//		hentity.setLastName(his.getLastName());
//		hentity.setEmail(his.getEmail());
//		hentity.setGender(his.getGender());
//		hentity.setPassword(his.getPassword());
		
		BeanUtils.copyProperties(his, hentity);  //its not working for registration
		
		
		
		
		
		
		HIS_EmployeeEntity en = empRepo.save(hentity);
		if(en!=null)
		{
			return eu.sendMail(his);
		}
		else{
		return false;
		}
	}
	
	@Override
	public String findPwdByEmail(String email) {
		String pazz = empRepo.getPwdByEmail(email);
		System.out.println("Password: "+pazz);
		return pazz;
	}




	@Override
	public int updatePwd(String email, String pwd) {
		String st=AppConstants.AFTER_ACCT_STATUS;
		Integer res = empRepo.updatePazzword(email, pwd,st);
		return res;
	}



	@Override
	public Page<HIS_EmployeeEntity> getAllEmps(Integer pageSize,Integer pageNo,String role) {
		
		//List<HIS_EmployeeEntity> allEmp = empRepo.findAll();
		PageRequest page = PageRequest.of(pageNo, pageSize);
		System.out.println("****came to service class*********");
		Page<HIS_EmployeeEntity> findAllByRole = erepo.findAllByRole(role, page);
		
		
		return findAllByRole;
		
		
		
		
	}
	
	@Override
	public int deleteEmployee(int eid) {
		String msg="YES";
		Integer del = empRepo.softDeleteEmployee(eid,msg);
		return del;
	}

	@Override
	public int activateEmployee(int eid) {
		String msg="NO";
		Integer act = empRepo.softActivateEmployee(eid, msg);
		return act;
	}
	

	@Override
	public HIS_Employee getEmployeeById(int eid) {
		Optional<HIS_EmployeeEntity> re = empRepo.findById(eid);
		
		
		if(re.isPresent())
		{
			HIS_EmployeeEntity ent=re.get();
			HIS_Employee hemp=new HIS_Employee();
			
			hemp.setEid(ent.getEid());
			hemp.setFirstName(ent.getFirstName());
			hemp.setLastName(ent.getLastName());
			hemp.setGender(ent.getGender());
			hemp.setRole(ent.getRole());
			hemp.setDeleteSwitch(ent.getDeleteSwitch());
			hemp.setEmail(ent.getEmail());
			hemp.setAcct_status(ent.getAcct_status());
			hemp.setPhoneNumber(ent.getPhoneNumber());
			
			return hemp;
			
			
		}
		
		return null;
	}

	
	
	
	

	
	
	
	
	
	@Override
	public boolean checkCredentials(String email, String pwd) {
	HIS_EmployeeEntity en = empRepo.findByEmailAndPassword(email, pwd);
		if(en!=null)
		{
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean checkAcctStatus(String email) {
		String status = empRepo.getAcctStatus(email);
		System.out.println("Status from service class: "+status);
		if(status.equals(AppConstants.ACCT_STATUS))
			return false;
		else
		{
			return true;
		} 
	}
	
	@Override
	public boolean checkEmail(String email) {
		HIS_EmployeeEntity ue = empRepo.findByEmail(email);	
		if(ue!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean checkEmailForLogin(String email) {
		HIS_EmployeeEntity uen = empRepo.findByEmail(email);
		//System.out.println("Email from service: "+uen.getEmail());
		boolean res=false;
		if(uen.getEmail()!=null)
		{
			res=true;
		}
		return res;
	}
	
	@Override
	public boolean findDeleteSwithValue(String email) {
		String del_status = empRepo.getDeleteSwitch(email);
		if(del_status.equals("NO"))
		{
			return true;
		}
		return false;
	}
	@Override
	public String findRole(String email) {
		String role = empRepo.getRole(email);
		return role;
	}
	
	@Override
	public Long getPhoneNumberByEmail(String email) {
		HIS_EmployeeEntity ue = empRepo.findByEmail(email);
		Long phno=ue.getPhoneNumber();
		return phno;
	}
	@Override
	public boolean sendPazzwordToMobile(String email) {
		HIS_EmployeeEntity ue = empRepo.findByEmail(email);
		Long phno=ue.getPhoneNumber();
		String pwd=ue.getPassword();
		boolean res=fpu.sendPwdMsg(phno, pwd);
		if(res)
			return true;
		return false; 
		
	}
	

}
