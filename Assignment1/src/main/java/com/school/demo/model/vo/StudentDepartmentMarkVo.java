package com.school.demo.model.vo;

import java.util.List;

import com.school.demo.model.Subject;

public class StudentDepartmentMarkVo {

	private int studId;
	
	private String studName;
	
	private String contactNumber;

	private int deptId;
	
	private String deptName;
	
	private String deptBranchName;

	private int recId;
	
	private int recyear;

	List<Subject> subjects;

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

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getRecyear() {
		return recyear;
	}

	public void setRecyear(int recyear) {
		this.recyear = recyear;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentDepartmentMarkVo [studId=" + studId + ", studName=" + studName + ", contactNumber=" + contactNumber + ", deptId="
				+ deptId + ", deptName=" + deptName + ", deptBranchName=" + deptBranchName + ", recId=" + recId
				+ ", recyear=" + recyear + ", subjects=" + subjects + "]";
	}
	
	
}
