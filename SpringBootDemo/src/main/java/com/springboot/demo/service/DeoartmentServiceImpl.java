package com.springboot.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;
import com.springboot.demo.repository.DepartmentRepository;

@Service
public class DeoartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	@Override
	public Department save(Department dept) {
		return repo.save(dept);
	}

	@Override
	public List<Department> fetchDept() {
		return repo.findAll();
	}

	@Override
	public Department fetchById(long deptId) throws DepartmentNotFoundException {
		Optional<Department> dept =  repo.findById(deptId);
		if(!dept.isPresent())
		{
			throw new DepartmentNotFoundException("Department not Available");
		}
		else
		return dept.get();
	}

	@Override
	public void deleteById(long deptId) {		
		repo.deleteById(deptId);		
	}

	@Override
	public Department updateDept(long deptId, Department dept) {
		Department depDb = repo.findById(deptId).get();
		
		if(Objects.nonNull(dept.getDeptName()) && !"".equalsIgnoreCase(dept.getDeptName()))
		{
			depDb.setDeptName(dept.getDeptName());
		}
		
		if(Objects.nonNull(dept.getDeptCode()) && !"".equalsIgnoreCase(dept.getDeptCode()))
		{
			depDb.setDeptCode(dept.getDeptCode());
		}
		
		if(Objects.nonNull(dept.getDeptAddress()) && !"".equalsIgnoreCase(dept.getDeptAddress()))
		{
			depDb.setDeptAddress(dept.getDeptAddress());
		}
		return repo.save(depDb);
	}

	@Override
	public Department getByName(String deptName) {
		return repo.findByDeptNameIgnoreCase(deptName);
	}

}
