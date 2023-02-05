package com.springboot.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.demo.entity.Department;
import com.springboot.demo.service.DepartmentService;

@WebMvcTest
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService deptSvc;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder().deptAddress("BHU").deptCode("HJ").deptName("HUJU").deptId(1L).build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inpD = Department.builder().deptAddress("BHU").deptCode("HJ").deptName("HUJU").deptId(1L).build();
		Mockito.when(deptSvc.save(inpD)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/department").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
				+ "    \"deptName\":\"HUJU\",\r\n"
				+ "    \"deptAddress\":\"BHU\",\r\n"
				+ "    \"deptCode\":\"HJ\"\r\n"
				+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFetchById() throws Exception {
		Mockito.when(deptSvc.fetchById(1L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.deptName").value(department.getDeptName()));
	}

}
