package com.school.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.school.demo.model.Student;
import com.school.demo.model.Subject;
import com.school.demo.model.vo.StudentDepartmentVo;

public interface StudentManagerDao {

	public String getMyName();
	public int add(Student student);
	public int update(Student student);
	public List<Student> getAll();
	public Student getById(int id);
	public int remove(int id);
	
	public List<StudentDepartmentVo> getAllByPage(Pageable pageable);
	
	public StudentDepartmentVo getStudentMark(int id);
	
	public List<Subject> getAllSubject(int deptId);
}
