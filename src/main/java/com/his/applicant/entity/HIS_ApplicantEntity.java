package com.his.applicant.entity;

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
@Table(name="HIS_APPLICANTS")
@Data
public class HIS_ApplicantEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="SSN")
	private String ssnNumber;
	
	
	@Column(name="dob")
	private String dob; 
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date",insertable = false)
	private Date updatedDate;

}
