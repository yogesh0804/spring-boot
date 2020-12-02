package com.school.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.school.demo.dao.AppUserManagementDao;
import com.school.demo.model.AppUser;

public class AppUserManagementDaoImpl implements AppUserManagementDao{

	@Autowired
	private JdbcTemplate jdbctemlate;
	
	private String QUERY_FOR_USER = "select app_usr_id,app_usr_nm, app_usr_pass from app_user where app_usr_nm = ?";
	
	@Override
	public AppUser getAppUser(String userName) {
		return jdbctemlate.queryForObject(QUERY_FOR_USER, (resultSet,numRow)->{
			AppUser appUser =  new AppUser();
			appUser.setAppUserId(resultSet.getInt("app_usr_id"));
			appUser.setAppUserName(resultSet.getString("app_usr_nm"));
			appUser.setPassword(resultSet.getString("app_usr_pass"));
			return appUser;	
		}, userName);
	}

}
