package com.school.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.demo.Encryption.FieldEncryptor;
import com.school.demo.dao.StudentManagerDao;
import com.school.demo.decryption.FieldDecryptor;
import com.school.demo.model.Student;
import com.school.demo.model.Subject;
import com.school.demo.model.vo.StudentDepartmentMarkVo;
import com.school.demo.model.vo.StudentDepartmentVo;
import com.school.demo.model.vo.StudentVo;
import com.school.demo.model.vo.SubjectVO;
import com.school.demo.service.StudentManagerService;
import com.school.demo.vo.mapper.StudentDeptMarkMapper;

@Repository
@Transactional
public class StudentManagerServiceImpl implements StudentManagerService {

	
	private  String ENKEY = "YogeshK008";
	
	@Autowired
	private StudentManagerDao studentManagerDao;

	@Override
	public int add(Student student) {
		student.setStudPassword(FieldEncryptor.encrypt(student.getStudPassword(), ENKEY));
		student.setContactNumber(FieldEncryptor.encrypt(student.getContactNumber(), ENKEY));
		student.setUserName((FieldEncryptor.encrypt(student.getUserName(), ENKEY)));
		student.setStudName(FieldEncryptor.encrypt(student.getStudName(), ENKEY));
		return studentManagerDao.add(student);
	}

	@Override
	public int update(Student student) {
		student.setStudPassword(FieldEncryptor.encrypt(student.getStudPassword(), ENKEY));
		student.setContactNumber(FieldEncryptor.encrypt(student.getContactNumber(), ENKEY));
		student.setUserName((FieldEncryptor.encrypt(student.getUserName(), ENKEY)));
		student.setStudName(FieldEncryptor.encrypt(student.getStudName(), ENKEY));
		return studentManagerDao.update(student);
	}

	@Override
	public List<Student> getAll() {		
		return studentManagerDao.getAll();
	}

	@Override
	public Student getById(int id) {
		Student student = studentManagerDao.getById(id);
		if(student != null) {
			student.setStudPassword(FieldDecryptor.decrypt(student.getStudPassword(), ENKEY));
			student.setContactNumber(FieldDecryptor.decrypt(student.getContactNumber(), ENKEY));
			student.setUserName((FieldDecryptor.decrypt(student.getUserName(), ENKEY)));
			student.setStudName(FieldDecryptor.decrypt(student.getStudName(), ENKEY));
			return student;
		}else {
			return null;
		}
	}

	@Override
	public int remove(int id) {
		return studentManagerDao.remove(id);
	}

	public StudentDepartmentVo getStudentMark(int id) {
		return studentManagerDao.getStudentMark(id);
	}

	@Override
	public StudentDepartmentMarkVo getStudentDeptMark(int id) {
		StudentDepartmentVo student = studentManagerDao.getStudentMark(id);
		List<Subject> subjects = studentManagerDao.getAllSubject(student.getDeptId());
		
		return StudentDeptMarkMapper.mapStudentAndSubjectToStudentDepartmentMarkVo(student, subjects);
	}

	@Override
	public List<StudentDepartmentMarkVo> getAllByPage(Pageable pageable) {
		List<StudentDepartmentMarkVo> departmentMarkVos = new ArrayList<StudentDepartmentMarkVo>();
		List<StudentDepartmentVo> departmentVos = studentManagerDao.getAllByPage(pageable);
		if (departmentVos.size() > 0) {
			for (StudentDepartmentVo departmentVo : departmentVos) {
				List<Subject> subjects = studentManagerDao.getAllSubject(departmentVo.getDeptId());
				departmentMarkVos.add(
						StudentDeptMarkMapper.mapStudentAndSubjectToStudentDepartmentMarkVo(departmentVo, subjects));
			}
		}
		return departmentMarkVos;
	}

	@Override
	public String getMyName() {
		return studentManagerDao.getMyName();
	}

}
