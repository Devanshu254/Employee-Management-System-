package com.cts.ems.service;

import com.cts.ems.dto.JwtAuthResponse;
import com.cts.ems.dto.LoginDto;
import com.cts.ems.dto.RegisterDto;

public interface AuthService {
	String register(RegisterDto registerDto);
	
	JwtAuthResponse login(LoginDto loginDto);
}
