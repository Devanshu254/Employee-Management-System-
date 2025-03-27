package com.cts.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
