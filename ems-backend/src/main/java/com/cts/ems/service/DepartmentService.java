package com.cts.ems.service;

import java.util.List;

import com.cts.ems.dto.DepartmentDto;

public interface DepartmentService {
//	Created Create Department method within our interface.
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
//	Created getDepartment by Id method within our interface.
	DepartmentDto getDepartmentById(Long departmentId);
	
//	Created get all department so that we can get all the departments.
	List<DepartmentDto> getAllDepartments();
	
//	Below method will be used to update the department details.
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
	
//	Below method will be used to delete the department.
	void deleteDepartment(Long departmentId);
}
