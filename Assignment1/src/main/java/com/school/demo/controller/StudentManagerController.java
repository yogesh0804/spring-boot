package com.school.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.demo.model.Student;
import com.school.demo.model.vo.StudentDepartmentMarkVo;
import com.school.demo.model.vo.StudentDepartmentVo;
import com.school.demo.model.vo.StudentVo;
import com.school.demo.service.StudentManagerService;

@RestController
@RequestMapping("/api")
public class StudentManagerController {

	@Autowired
	private StudentManagerService studentService;

	@GetMapping("/me")
	public String getMyName() {
		return studentService.getMyName();
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> list() {
		List<Student> students = studentService.getAll();
		if(students.size()>0) {
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
		 
	}

	@GetMapping("/student/{studId}")
	public ResponseEntity<Student> get(@PathVariable Integer studId) {
		Student student = new Student();
		try {
			
			student = studentService.getById(studId);
			if(student != null) {
				return new ResponseEntity<Student>(student, HttpStatus.OK);
			}else {
				return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/studentWithDeptAndMark/{studId}")
	public ResponseEntity<StudentDepartmentMarkVo> getStudDept(@PathVariable Integer studId) {
		try {
			StudentDepartmentMarkVo student = studentService.getStudentDeptMark(studId);
			return new ResponseEntity<StudentDepartmentMarkVo>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentDepartmentMarkVo>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/studentWithDept/{studId}")
	public ResponseEntity<StudentDepartmentVo> getStudDeptAndMark(@PathVariable Integer studId) {
		try {
			StudentDepartmentVo stStudentDepartmentMarkVoudent = studentService.getStudentMark(studId);
			return new ResponseEntity<StudentDepartmentVo>(stStudentDepartmentMarkVoudent, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentDepartmentVo>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/student")
	public void add(@Valid @RequestBody Student student) {
		studentService.add(student);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
		try {
			Student stud = studentService.getById(id);
			studentService.update(student);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/student/delete/{id}")
	public void delete(@PathVariable Integer id) {
		studentService.remove(id);
	}

	@GetMapping(params = { "page", "size" })
	public List<StudentDepartmentMarkVo> getStudentWithMarksByPage(@RequestParam("page") final int page,
			@RequestParam("size") final int size) {

		PageRequest pageable = new PageRequest(page, size);

		try {
				List<StudentDepartmentMarkVo> result = studentService.getAllByPage(pageable);
				return result;
		}catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

}
