package com.cts.ems.mapper;

import com.cts.ems.dto.DepartmentDto;
import com.cts.ems.entity.Department;

public class DepartmentMapper {
	// Convert department jpa entity into department dto.
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
				);
	}
	// Convert department dto into jpa entity 
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
				);
	}
	
}
