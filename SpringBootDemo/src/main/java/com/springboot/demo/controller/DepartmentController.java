package com.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;
import com.springboot.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	private final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/department")
	public Department saveDepartment(@Valid @RequestBody Department dept)
	{
		log.info("Inside save");
		return deptService.save(dept);
	}
	
	@GetMapping("/department")
	public List<Department> getDepartmrnts()
	{
		log.info("Inside fetch");
		return deptService.fetchDept();
	}
	
	@GetMapping("/department/{id}")
	public Department fetchById(@PathVariable("id")long deptId) throws DepartmentNotFoundException
	{
		return deptService.fetchById(deptId);
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteById(@PathVariable("id") long deptId)
	{
		deptService.deleteById(deptId);
		return "Deleted Successfully";
	}
	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable("id") long deptId, @RequestBody Department dept)
	{
		return deptService.updateDept(deptId,dept);
	}
	
	@GetMapping("/department/name/{name}")
	public Department fetchByName(@PathVariable("name")String deptName)
	{
		return deptService.getByName(deptName);
	}
}
