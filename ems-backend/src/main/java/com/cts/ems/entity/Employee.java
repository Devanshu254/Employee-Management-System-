package com.cts.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
//  Generating id.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // It uses data base auto increment feature.
	private Long id;
	
//	Generating firstName column.
	@Column(name = "first_name")
	private String firstName;
	
//	Generating lastName column.
	@Column(name = "last_name")
	private String lastName;
	
//	Generating email id.
	@Column(name = "email_id")
	private String email;
	
//	Creating many to one relationship between department and employee.
	@ManyToOne(fetch = FetchType.LAZY) // If we will call the department field of employee entity. It only fetches the department associated with it.
	@JoinColumn(name = "department_id")
	private Department department;
}
