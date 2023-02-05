package com.springboot.demo.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.demo.entity.Department;
import com.springboot.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService deptService;
	@MockBean
	private DepartmentRepository repo;
	
	@BeforeEach
	void setUp() {
		Department dept = Department.builder().deptName("IT").deptAddress("MNG").deptCode("IT09").deptId(1).build();
		
		Mockito.when(repo.findByDeptNameIgnoreCase("IT")).thenReturn(dept);
	}

	@Test
	@DisplayName("Get data based on valid department name")
	public void whenValidDeptNameThenDeptFound() {
		String deptName = "IT";
		Department found = deptService.getByName(deptName);
		assertEquals(deptName, found.getDeptName());
	}

}
