package com.school.demo.model.vo;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class StudentDepartmentVo {

	private int studId;
	
	private String studName;
	
	private String contactNumber;

	private int deptId;
	
	private String deptName;
	
	private String deptBranchName;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptBranchName() {
		return deptBranchName;
	}

	public void setDeptBranchName(String deptBranchName) {
		this.deptBranchName = deptBranchName;
	}

	@Override
	public String toString() {
		return "StudentDepartmentVo [studId=" + studId + ", studName=" + studName + ", contactNumber=" + contactNumber + ", deptId="
				+ deptId + ", deptName=" + deptName + ", deptBranchName=" + deptBranchName + "]";
	}
	
	
}
