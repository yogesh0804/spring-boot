package com.school.demo.model;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class Department extends AbstractDateTime{

	@Null
	private int deptId;
	
	@Size(min = 1, max = 50)
	private String deptName;
	
	@Size(min = 1, max = 50)
	private String deptBranchName;
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
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptBranchName=" + deptBranchName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deptBranchName == null) ? 0 : deptBranchName.hashCode());
		result = prime * result + deptId;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptBranchName == null) {
			if (other.deptBranchName != null)
				return false;
		} else if (!deptBranchName.equals(other.deptBranchName))
			return false;
		if (deptId != other.deptId)
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		return true;
	}
	
	
	
}
