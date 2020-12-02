package com.school.demo.model;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class Subject{

	@Null
	private int subId;
	
	@Size(min = 1, max = 50)
	private String subName;
	
	@NumberFormat
	private int totalMark;
	
	@NumberFormat
	private int obtMark;
	
	@NumberFormat
	private int subDeptId;
	
	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	public int getObtMark() {
		return obtMark;
	}

	public void setObtMark(int obtMark) {
		this.obtMark = obtMark;
	}

	public int getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}



	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", totalMark=" + totalMark + ", obtMark=" + obtMark
				+ ", subDeptId=" + subDeptId + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + obtMark;
		result = prime * result + subDeptId;
		result = prime * result + subId;
		result = prime * result + ((subName == null) ? 0 : subName.hashCode());
		result = prime * result + totalMark;
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
		Subject other = (Subject) obj;
		if (obtMark != other.obtMark)
			return false;
		if (subDeptId != other.subDeptId)
			return false;
		if (subId != other.subId)
			return false;
		if (subName == null) {
			if (other.subName != null)
				return false;
		} else if (!subName.equals(other.subName))
			return false;
		if (totalMark != other.totalMark)
			return false;
		return true;
	}

}
