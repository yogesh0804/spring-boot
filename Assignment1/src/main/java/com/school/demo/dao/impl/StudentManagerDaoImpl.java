package com.school.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.demo.dao.StudentManagerDao;
import com.school.demo.model.Student;
import com.school.demo.model.Subject;
import com.school.demo.model.vo.StudentDepartmentVo;

@Repository
public class StudentManagerDaoImpl implements StudentManagerDao{

	
	private String OPERATOR = "Yogesh";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String QUERY_FOR_ALL_STUDENT = "select * from student";
	private String QUERY_FOR_BY_ID_STUDENT = "select * from student where stud_id = ?";
	private String QUERY_FOR_UPDATE_STUDENT = "update student " + " set stud_nm = ?, stud_dob = ?, stud_addr = ?, stud_enr_dt = ?, stud_cont_no = ?, stud_dept_id = ? " + " where stud_id = ?";
	private String QUERY_FOR_INSERT_STUDENT = "insert into student (stud_nm,stud_dob,stud_addr,stud_enr_dt,stud_cont_no,stud_dept_id,created_by,dt_created,modif_by,dt_modif,user_nm,stud_pass) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private String QUERY_FOR_DELETER_STUDENT = "delete from student where stud_id=?";
	private String QUERY_FOR_STUDENT_DEPARTMENT = "SELECT s.stud_id, s.stud_nm, s.stud_cont_no,d.dept_id, d.dept_nm, d.dept_branch_type FROM student AS s INNER JOIN department AS d ON s.stud_dept_id = d.dept_id WHERE s.stud_id=?";
	private String QERERY_FOR_SUBJECT = "select * from subject where subject_dept_id = ?";
	private String QUERY_FOR_STDENT_MARK_BY_PAGE = "SELECT s.stud_id, s.stud_nm, s.stud_cont_no,d.dept_id, d.dept_nm, d.dept_branch_type FROM student AS s INNER JOIN department AS d ON s.stud_dept_id = d.dept_id LIMIT ? OFFSET ?";
	
	
	public class StudentMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudId(resultSet.getInt(1));
			student.setStudName(resultSet.getString(2));
			student.setStudDOB(resultSet.getDate(3));
			student.setAddress(resultSet.getString(4));
			student.setStudEDate(resultSet.getDate(5));
			student.setContactNumber(resultSet.getString(6));
			student.setStudDeptId(resultSet.getInt(7));
			student.setUserName(resultSet.getString("user_nm"));
			student.setStudPassword(resultSet.getString("stud_pass"));
			return student;
		}
		
	};
	
	@Override
	public int add(Student student) {
		return  jdbcTemplate.update(QUERY_FOR_INSERT_STUDENT, new Object[] {
						student.getStudName(),student.getStudDOB(),student.getAddress(),student.getStudEDate(),student.getContactNumber(),student.getStudDeptId(),OPERATOR,new Date(),OPERATOR,new Date(),student.getUserName(),student.getStudPassword()
				});
	}

	@Override
	public int update(Student student) {
		return jdbcTemplate.update(QUERY_FOR_UPDATE_STUDENT, new Object[] {
				student.getStudName(),student.getStudDOB(),student.getAddress(),student.getStudEDate(),student.getContactNumber(),student.getStudDeptId(),student.getStudId()
		});
	}

	@Override
	public List<Student> getAll() {
		
		return jdbcTemplate.query(QUERY_FOR_ALL_STUDENT, (resultSet, numRow)->{
			Student student = new Student();
			student.setStudId(resultSet.getInt(1));
			student.setStudName(resultSet.getString(2));
			student.setStudDOB(resultSet.getDate(3));
			student.setAddress(resultSet.getString(4));
			student.setStudEDate(resultSet.getDate(5));
			student.setContactNumber(resultSet.getString(6));
			student.setStudDeptId(resultSet.getInt(7));
			return student;
		});
	}

	@Override
	public Student getById(int id) {
		Student student = new Student();
		try {
			student = jdbcTemplate.queryForObject(QUERY_FOR_BY_ID_STUDENT,new StudentMapper(), id); 
		}catch (Exception e) {
			return null;
		}
		return student;
	}

	@Override
	public int remove(int id) {
		 return jdbcTemplate.update(QUERY_FOR_DELETER_STUDENT, new Object[] {
		            id
		        });
	}
	
	public StudentDepartmentVo getStudentMark(int id) {
		return jdbcTemplate.queryForObject(QUERY_FOR_STUDENT_DEPARTMENT,(rs,numRow)->{
			StudentDepartmentVo departmentMarkVo = new StudentDepartmentVo();
			departmentMarkVo.setStudId(rs.getInt("stud_id"));
			departmentMarkVo.setStudName(rs.getString("stud_nm"));
			departmentMarkVo.setContactNumber(rs.getString("stud_cont_no"));
			departmentMarkVo.setDeptId(rs.getInt("dept_id"));
			departmentMarkVo.setDeptName(rs.getString("dept_nm"));
			departmentMarkVo.setDeptBranchName(rs.getString("dept_branch_type"));
			return departmentMarkVo;
		}, id);	
	}

	@Override
	public List<Subject> getAllSubject(int deptId) {
		return jdbcTemplate.query(QERERY_FOR_SUBJECT,(rs,numRow)->{
			Subject sub = new Subject();
			sub.setSubId(rs.getInt(1));
			sub.setSubName(rs.getString(2));
			sub.setTotalMark(rs.getInt(3));
			sub.setObtMark(rs.getInt("sub_obt_mark"));
			return sub;
		}, deptId);		
		
	}

	@Override
	public List<StudentDepartmentVo> getAllByPage(Pageable pageable) {

		List<StudentDepartmentVo> students = jdbcTemplate.query(QUERY_FOR_STDENT_MARK_BY_PAGE, (rs, rowNum) -> {
			StudentDepartmentVo departmentMarkVo = new StudentDepartmentVo();
			departmentMarkVo.setStudId(rs.getInt("stud_id"));
			departmentMarkVo.setStudName(rs.getString("stud_nm"));
			departmentMarkVo.setContactNumber(rs.getString("stud_cont_no"));
			 departmentMarkVo.setDeptId(rs.getInt("dept_id")); 
			departmentMarkVo.setDeptName(rs.getString("dept_nm"));
			departmentMarkVo.setDeptBranchName(rs.getString("dept_branch_type"));
			return departmentMarkVo;
		}, new Object[] {pageable.getPageSize(), pageable.getPageNumber()});
		
		return  students;
	}

	@Override
	public String getMyName() {
		return "Yogesh";
	}

}
