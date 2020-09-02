package com.his.admin.binding;

import lombok.Data;

@Data
public class UnlockAccount {
	private String acctEmail;
	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;
	
//	public String getAcctEmail() {
//		return acctEmail;
//	}
//	public void setAcctEmail(String acctEmail) {
//		this.acctEmail = acctEmail;
//	}
//	public String getOldPassword() {
//		return oldPassword;
//	}
//	public void setOldPassword(String oldPassword) {
//		this.oldPassword = oldPassword;
//	}
//	public String getNewPassword() {
//		return newPassword;
//	}
//	public void setNewPassword(String newPassword) {
//		this.newPassword = newPassword;
//	}
//	public String getConfirmNewPassword() {
//		return confirmNewPassword;
//	}
//	public void setConfirmNewPassword(String confirmNewPassword) {
//		this.confirmNewPassword = confirmNewPassword;
//	}

}
