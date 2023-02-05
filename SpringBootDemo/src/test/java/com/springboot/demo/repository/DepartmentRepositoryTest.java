package com.springboot.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.demo.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private TestEntityManager entity;
	
	@BeforeEach
	void setUp()
	{
		Department department = Department.builder().deptName("ME").deptCode("ME01").deptAddress("Delji").build();
		
		entity.persist(department);
	}
	
	@Test
	void whenFindById_ReturnDeptName() {
		Department dept = repo.findById(1L).get();
		assertEquals(dept.getDeptName(), "ME");
	}

}
