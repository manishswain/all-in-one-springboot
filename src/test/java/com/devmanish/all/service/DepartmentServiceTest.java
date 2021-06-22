package com.devmanish.all.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.devmanish.all.entity.Department;
import com.devmanish.all.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("IT").departmentAddress("BBSR")
				.departmentCode("IT09").departmentId(1L).build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
	
	}

	@Test
	@DisplayName("Get Data based on Valid Department Name")
	public void whenValidDepartmentname_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchdepartmentByName(departmentName);

		assertEquals(departmentName, found.getDepartmentName());
	}

}
