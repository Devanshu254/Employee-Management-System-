package com.cts.ems.repository;

import com.cts.ems.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
//	Below method will retrieve a user object by user name.
	Optional<User> findByUsername(String username); 
	
//	Below method will basically check whether the user object by this email is exist in the database or not.
	Boolean existsByEmail(String email);
	
//	This custom query method will retrieve a user object by user name or email.
	Optional<User> findByUsernameOrEmail(String username, String email);
	
//	Custom query method that will check whether user exist within database or not.
	Boolean existsByUsername(String username);
}
