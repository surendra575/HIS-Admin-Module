package com.his.plans.binding;

import lombok.Data;

@Data
public class HIS_Plans {
	private int planId;
	private String planName;
	private String planDescription;
	private String planStartDate;
	private String planEndDate;
	private String activeSwitch;

}
