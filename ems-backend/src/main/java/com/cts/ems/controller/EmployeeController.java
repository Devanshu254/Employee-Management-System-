package com.cts.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ems.dto.EmployeeDto;
import com.cts.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	// Build Add Employee Rest API
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	// Build Get Employees REST API
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId); 
		return ResponseEntity.ok(employeeDto);
	}
	
	// Build Get All Employees REST API
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	// Build Update Employee REST API
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	// Build Delete Employee REST API
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!.");
	}
}
