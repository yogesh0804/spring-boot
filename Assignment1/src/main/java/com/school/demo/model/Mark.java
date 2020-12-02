package com.school.demo.model;

import javax.validation.constraints.Null;

import org.springframework.format.annotation.NumberFormat;

public class Mark extends AbstractDateTime{

	@Null
	private int recId;
	
	@NumberFormat
	private int recyear;
	
	@NumberFormat
	private int markStudId;
	
	@NumberFormat
	private int markDeptId;
	
	
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
	public int getMarkStudId() {
		return markStudId;
	}
	public void setMarkStudId(int markStudId) {
		this.markStudId = markStudId;
	}
	public int getMarkDeptId() {
		return markDeptId;
	}
	public void setMarkDeptId(int markDeptId) {
		this.markDeptId = markDeptId;
	}
	@Override
	public String toString() {
		return "Mark [recId=" + recId + ", recyear=" + recyear + ", markStudId=" + markStudId + ", markDeptId="
				+ markDeptId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + markDeptId;
		result = prime * result + markStudId;
		result = prime * result + recId;
		result = prime * result + recyear;
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
		Mark other = (Mark) obj;
		if (markDeptId != other.markDeptId)
			return false;
		if (markStudId != other.markStudId)
			return false;
		if (recId != other.recId)
			return false;
		if (recyear != other.recyear)
			return false;
		return true;
	}
	
	
	
}
