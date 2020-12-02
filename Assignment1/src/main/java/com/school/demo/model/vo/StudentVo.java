package com.school.demo.model.vo;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.school.demo.model.Student;
import com.school.demo.vo.mapper.ModelObjectMapper;

public class StudentVo {

	private int studId;
	
	@Size(min = 1, max = 50)
	private String studName;
	 
	@DateTimeFormat
	private Date studDOB;
	
	@Size(min = 1, max = 50)
	private String address;
	
	@DateTimeFormat
	private Date studEDate;
	
	@Size(max = 13)
	@NumberFormat
	private String contactNumber;
	
	@NumberFormat
	private int studDeptId;

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

	public Date getStudDOB() {
		return studDOB;
	}

	public void setStudDOB(Date studDOB) {
		this.studDOB = studDOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStudEDate() {
		return studEDate;
	}

	public void setStudEDate(Date studEDate) {
		this.studEDate = studEDate;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getStudDeptId() {
		return studDeptId;
	}

	public void setStudDeptId(int studDeptId) {
		this.studDeptId = studDeptId;
	}

	@Override
	public String toString() {
		return "StudentVo [studId=" + studId + ", studName=" + studName + ", studDOB=" + studDOB + ", address="
				+ address + ", studEDate=" + studEDate + ", contactNumber=" + contactNumber + ", studDeptId="
				+ studDeptId + "]";
	}

	
}
