package com.cts.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.ems.dto.DepartmentDto;
import com.cts.ems.entity.Department;
import com.cts.ems.exception.ResourceNotFoundException;
import com.cts.ems.mapper.DepartmentMapper;
import com.cts.ems.repository.DepartmentRepository;
import com.cts.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;

	// Below method will implement the create department method
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with given id: "+departmentId)
			);
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	// Below method is an implementation of getting all the departments.
	@Override
	public List<DepartmentDto> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentRepository.findAll();
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	// Below method will implement the update department.
	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with given id: "+departmentId)
			);
		department.setDepartmentName(updatedDepartment.getDepartmentName());
		department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	// Below method is an implementation of delete department method in service interface.
	@Override
	public void deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with the given id: "+ departmentId)
				);
		departmentRepository.deleteById(departmentId);
	}
	
}
