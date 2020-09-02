package com.his.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="HIS_EMPLOYEE_ROLES")
@Data
public class HIS_RolesEntity {
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;

//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
	
	
	
	

}
