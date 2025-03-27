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

import com.cts.ems.dto.DepartmentDto;
import com.cts.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	// Build Create or Add department REST API
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	// Build Get Department REST API
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDto);
	}
	
	// Build Get All Departments REST API
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
	
	// Build Update Department REST API.
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartment) {
		DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
		return ResponseEntity.ok(departmentDto);
	}
	
	// Build delete department REST API.
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department deleted successfully!");
	}
}
