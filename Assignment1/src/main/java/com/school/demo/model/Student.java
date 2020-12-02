package com.school.demo.model;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.school.demo.model.vo.StudentVo;
import com.school.demo.vo.mapper.ValueObjectMapper;

public class Student {


	
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
	
	@org.hibernate.validator.constraints.Email
	private String userName;
	
	private String studPassword;
	
	
	
	public Student(int studId, @Size(min = 1, max = 50) String studName, Date studDOB,
			@Size(min = 1, max = 50) String address, Date studEDate, @Size(max = 13) String contactNumber,
			int studDeptId, @org.hibernate.validator.constraints.Email String userName, String studPassword) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studDOB = studDOB;
		this.address = address;
		this.studEDate = studEDate;
		this.contactNumber = contactNumber;
		this.studDeptId = studDeptId;
		this.userName = userName;
		this.studPassword = studPassword;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStudPassword() {
		return studPassword;
	}
	public void setStudPassword(String studPassword) {
		this.studPassword = studPassword;
	}
	public int getStudDeptId() {
		return studDeptId;
	}
	public void setStudDeptId(int studDeptId) {
		this.studDeptId = studDeptId;
	}
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
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studDOB=" + studDOB + ", address=" + address
				+ ", studEDate=" + studEDate + ", contactNumber=" + contactNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((studDOB == null) ? 0 : studDOB.hashCode());
		result = prime * result + ((studEDate == null) ? 0 : studEDate.hashCode());
		result = prime * result + studId;
		result = prime * result + ((studName == null) ? 0 : studName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (studDOB == null) {
			if (other.studDOB != null)
				return false;
		} else if (!studDOB.equals(other.studDOB))
			return false;
		if (studEDate == null) {
			if (other.studEDate != null)
				return false;
		} else if (!studEDate.equals(other.studEDate))
			return false;
		if (studId != other.studId)
			return false;
		if (studName == null) {
			if (other.studName != null)
				return false;
		} else if (!studName.equals(other.studName))
			return false;
		return true;
	}
	}
