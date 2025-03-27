package com.cts.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// When JPA or Hibernate fetches data from db, it instantiate the entities using reflection.
// To instantiate entity via reflection we are required to generate no-args and all-args constructor.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
//	Generating the ID.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	Generating department column.
	@Column(name = "department_name")
	private String departmentName;
	
//	Generating departmentdescription column.
	@Column(name = "department_description")
	private String departmentDescription;
}
