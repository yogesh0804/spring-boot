package com.school.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.school.demo.model.Student;
import com.school.demo.model.vo.StudentDepartmentMarkVo;
import com.school.demo.model.vo.StudentDepartmentVo;

public interface StudentManagerService {

	public String getMyName();
	public int add(Student student);
	public int update(Student student);
	public List<Student> getAll();
	public List<StudentDepartmentMarkVo> getAllByPage(Pageable pageable);
	public Student getById(int id);
	public int remove(int id);
	
	public StudentDepartmentVo getStudentMark(int id);
	
	public StudentDepartmentMarkVo getStudentDeptMark(int id);
}
