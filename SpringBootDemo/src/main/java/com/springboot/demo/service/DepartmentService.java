package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department save(Department dept);

	List<Department> fetchDept();

	Department fetchById(long deptId) throws DepartmentNotFoundException;

	void deleteById(long deptId);

	Department updateDept(long deptId, Department dept);

	Department getByName(String deptName);

}
