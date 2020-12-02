package com.school.demo.model.vo;

public class AppUserVo {

	private int appUserId;

	private String appUserName;
	
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
		return "AppUserVo [appUserId=" + appUserId + ", appUserName=" + appUserName + ", Password=" + Password + "]";
	}

	
}
