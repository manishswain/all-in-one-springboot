package com.devmanish.all.controller;

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

import com.devmanish.all.entity.Department;
import com.devmanish.all.error.DepartmentNotFoundException;
import com.devmanish.all.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of Department Controller");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartmentList of Department Controller");
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartmentbyId(@PathVariable("id") long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentbyId(departmentId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody Department department)
	{
		return departmentService.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchdepartmentByName(@PathVariable("name") String departmentName)
	{
		return departmentService.fetchdepartmentByName(departmentName);
	}
}
