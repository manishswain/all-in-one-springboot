package com.devmanish.all.service;

import java.util.List;

import com.devmanish.all.entity.Department;
import com.devmanish.all.error.DepartmentNotFoundException;


public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentbyId(long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchdepartmentByName(String departmentName);

}
