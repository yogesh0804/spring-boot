package com.school.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.school.demo.dao.impl.StudentManagerDaoImpl;
import com.school.demo.model.Student;
import com.school.demo.service.impl.StudentManagerServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class Assignment1ApplicationTests {
	
	@InjectMocks
	StudentManagerServiceImpl studentManagerService;
	
	@Mock
	StudentManagerDaoImpl studentManagerDao;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    } 
	
	@Test
	public void testCheckMyName() {
		when(studentManagerService.getMyName()).thenReturn(new String("Ganesh"));
		assertEquals("Ganesh", studentManagerDao.getMyName());
	}
	
	@Test
	public void testGetAllEmployee() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Yogesh", new Date(2020, 11, 05), "Gangapur", new Date(2020, 11, 05), "9876543210", 3, "yogesh@gmail.com", "yogesh#123"));
		students.add(new Student(2, "Ganesh", new Date(2020, 11, 05), "Nagpur", new Date(2020, 11, 05), "9876543210", 3, "Ganesh@gmail.com", "Ganesh#123"));
		students.add(new Student(3, "Ganesh", new Date(2020, 11, 05), "A.Nagar", new Date(2020, 11, 05), "9876543210", 3, "rahul@gmail.com", "rahul#123"));
	
		when(studentManagerDao.getAll()).thenReturn(students);
		
		List<Student> list = studentManagerService.getAll();
		
		assertEquals(3, list.size());
        verify(studentManagerDao, times(1)).getAll();
	}

	@Test
	public void testCheckGetByIdAPI() {
		when(studentManagerDao.getById(15)).thenReturn(new Student(1, "Yogesh", new Date(2020, 11, 05), "Gangapur", new Date(2020, 11, 05), "9876543210", 3, "yogesh@gmail.com", "yogesh#123"));
        
        Student stud = studentManagerService.getById(15);
         
        assertEquals("Yogesh", stud.getStudName());
        assertEquals("9876543210", stud.getContactNumber());
        assertEquals("yogesh@gmail.com", stud.getUserName());
	}
	
	/*
	 * @Test public void testCheckGetByIdAPI() { Student student =
	 * restTemplate.getForObject(getRootUrl() + "/student/15", Student.class);
	 * System.out.println(student.getStudName()); assertNotNull(student); }
	 */

	@Test
	public void testCheckUpdateAPI() {
		Student student = new Student(1, "Yogesh", new Date(2020, 11, 05), "Gangapur", new Date(2020, 11, 05), "9876543210", 3, "yogesh@gmail.com", "yogesh#123");
		when(studentManagerDao.update(student)).thenReturn(1);
        
        int returnValue = studentManagerService.update(student);
        
        assertEquals(1, returnValue);
        
        verify(studentManagerDao, times(1)).update(student);
	}
	
	@Test
	public void testCheckInsertAPI() {
		Student student = new Student(1, "Yogesh", new Date(2020, 11, 05), "Gangapur", new Date(2020, 11, 05), "9876543210", 3, "yogesh@gmail.com", "yogesh#123");
	
		studentManagerService.add(student);
		
		 verify(studentManagerDao, times(1)).add(student);
	}
	

	@Test
	public void testCheckDeleteAPI() {
		when(studentManagerDao.remove(1)).thenReturn(1);
        
        int returnValue = studentManagerService.remove(1);
        
        assertEquals(1, returnValue);
        
        verify(studentManagerDao, times(1)).remove(1);
	}


}
