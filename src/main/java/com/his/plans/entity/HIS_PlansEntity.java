package com.his.plans.entity;

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
@Table(name="HIS_PLANS")
@Data
public class HIS_PlansEntity {
	
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private int planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESCRIPTION")
	private String planDescription;
	
	@Column(name="PLAN_STARTDATE")
	private String planStartDate;
	
	@Column(name="PLAN_ENDDATE")
	private String planEndDate;
	
	@Column(name="ACTIVE_SWITCH")
	private String activeSwitch;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable = false)
	private Date updatedDate;

}
