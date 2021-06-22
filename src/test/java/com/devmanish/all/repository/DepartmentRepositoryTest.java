package com.devmanish.all.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.devmanish.all.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager entityManager;

//	@BeforeEach
//	void setUp() throws Exception {
//		Department department = Department.builder().departmentName("Mechanical Engineering").departmentCode("ME-011")
//				.departmentAddress("Delhi").build();
//
//		entityManager.persist(department);
//
//	}
//
//	@Test
//	public void whenFindById_thenreturnDepartment() {
//		Department department = departmentRepository.findById(1L).get();
//		assertEquals(department.getDepartmentName(), "Mechanical Engineering");
//	}

}
