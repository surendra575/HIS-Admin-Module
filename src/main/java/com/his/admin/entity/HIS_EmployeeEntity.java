package com.his.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="HIS_EMPLOYEE")
@Data
public class HIS_EmployeeEntity {
	@Id
	@GeneratedValue
	@Column(name="eid")
	private Integer eid;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="role")
	private String role;
	
	@Column(name="status")
	private String acct_status;
	
	@Column(name="password")
	private String password;
	
	@Column(name="delete_switch")
	private String deleteSwitch;
	
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date",insertable = false)
	private Date updatedDate;
	
	
	

	
	

}
