package com.cts.ems.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.ems.dto.JwtAuthResponse;
import com.cts.ems.dto.LoginDto;
import com.cts.ems.dto.RegisterDto;
import com.cts.ems.entity.Role;
import com.cts.ems.entity.User;
import com.cts.ems.exception.APIException;
import com.cts.ems.repository.RoleRepository;
import com.cts.ems.repository.UserRepository;
import com.cts.ems.security.JwtTokenProvider;
import com.cts.ems.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public String register(RegisterDto registerDto) {
//		Check if user name already exist in data base.
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "User name already exists!");
		}
		
//		Check if email already exists in database.
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "Email is already exists!");
		}
		
//		Let us create a user object and we will store that user object into database.
		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName("ROLE_USER");
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
		return "User Registered Successfully!.";
	}

	@Override
	public JwtAuthResponse login(LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsernameOrEmail(), 
				loginDto.getPassword()
		));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		
		Optional<User> userOptional = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), 
				loginDto.getUsernameOrEmail());
		
		String role = null;
		if(userOptional.isPresent()) {
			User loggedInUser = userOptional.get();
			Optional<Role> optionalRole = loggedInUser.getRoles().stream().findFirst();
			
			if(optionalRole.isPresent()) {
				Role userRole = optionalRole.get();
				role = userRole.getName();
			}
		}
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setRole(role);
		jwtAuthResponse.setAccessToken(token);
		return jwtAuthResponse;
	}

}
