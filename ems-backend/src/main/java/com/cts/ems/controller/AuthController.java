package com.cts.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ems.dto.JwtAuthResponse;
import com.cts.ems.dto.LoginDto;
import com.cts.ems.dto.RegisterDto;
import com.cts.ems.service.AuthService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	
//	Build Register REST API.
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
		String response = authService.register(registerDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
//	Build Login REST API.
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
		JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
		return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
	}
}
