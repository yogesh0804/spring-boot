package com.school.demo.model.vo;

import com.school.demo.model.Subject;
import com.school.demo.vo.mapper.ModelObjectMapper;

public class SubjectVO {

	private int subId;
	
	private String subName;
	
	private int totalMark;
	
	private int obtMark;

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

	@Override
	public String toString() {
		return "SubjectVO [subId=" + subId + ", subName=" + subName + ", totalMark=" + totalMark + ", obtMark="
				+ obtMark + "]";
	}
}
