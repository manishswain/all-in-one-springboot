package com.devmanish.all.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmanish.all.entity.Department;
import com.devmanish.all.error.DepartmentNotFoundException;
import com.devmanish.all.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);

	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentbyId(long departmentId) throws DepartmentNotFoundException {
		 Optional<Department> department = departmentRepository.findById(departmentId);
		 
		 if(!department.isPresent())
		 {
			 throw new DepartmentNotFoundException("DEPARTMENT NOT AVAILABLE");
		 }
		 return department.get();
	}

	@Override
	public void deleteDepartmentById(long departmentId) {

		departmentRepository.deleteById(departmentId);

	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {

		Department dep = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			dep.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			dep.setDepartmentCode(department.getDepartmentCode());
		}
		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dep.setDepartmentAddress(department.getDepartmentAddress());
		}

		return departmentRepository.save(dep);
	}

	@Override
	public Department fetchdepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
