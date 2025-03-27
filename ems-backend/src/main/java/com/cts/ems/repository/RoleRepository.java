package com.cts.ems.repository;

import com.cts.ems.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
//	Custom Query Method that will retrieve a role object by name.
	Role findByName(String name);
}
