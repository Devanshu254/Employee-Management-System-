package com.cts.ems.service;

import java.util.List;

import com.cts.ems.dto.EmployeeDto;

public interface EmployeeService {
//	Create Employee Method which is used to create an employee in our project.
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
//	Created Get Employee Method so that we can get all the employees which we have created.
	EmployeeDto getEmployeeById(Long employeeId);
	
//  REST API to Get All Employees.
	List<EmployeeDto> getAllEmployees();
	
//	REST API to update employee.
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
//	REST API to delete employee.
	void deleteEmployee(Long employeeId);
}
