package com.school.demo.vo.mapper;

import java.util.List;

import com.school.demo.model.Subject;
import com.school.demo.model.vo.StudentDepartmentMarkVo;
import com.school.demo.model.vo.StudentDepartmentVo;
import com.school.demo.model.vo.SubjectVO;

public class StudentDeptMarkMapper {

	public static StudentDepartmentMarkVo mapStudentAndSubjectToStudentDepartmentMarkVo(StudentDepartmentVo s,List<Subject> subjects) {
		
		StudentDepartmentMarkVo studentDepartmentMarkVo = new StudentDepartmentMarkVo();
		studentDepartmentMarkVo.setStudId(s.getStudId());
		studentDepartmentMarkVo.setStudName(s.getStudName());
		studentDepartmentMarkVo.setContactNumber(s.getContactNumber());
		studentDepartmentMarkVo.setDeptId(s.getDeptId());
		studentDepartmentMarkVo.setDeptName(s.getDeptName());
		studentDepartmentMarkVo.setDeptBranchName(s.getDeptBranchName());
		studentDepartmentMarkVo.setSubjects(subjects);
		return studentDepartmentMarkVo;
	}
}
