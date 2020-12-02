package com.school.demo.model;


public class AppUser extends AbstractDateTime{

	
	private int appUserId;

	@javax.validation.constraints.NotBlank
	private String appUserName;
	
	@javax.validation.constraints.NotBlank
	private String Password;

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public String getAppUserName() {
		return appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "AppUser [appUserId=" + appUserId + ", appUserName=" + appUserName + ", Password=" + Password + "]";
	}
	
	
	
}
