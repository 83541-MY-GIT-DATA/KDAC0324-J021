package com.sunBank.services;

import org.springframework.stereotype.Service;

import com.sunBank.dtos.ChangePasswordRequestDto;
import com.sunBank.dtos.ChangePasswordResponseDto;

@Service
public interface CustomerService {
	
	ChangePasswordResponseDto changePassword(ChangePasswordRequestDto changePasswordRequestDto);
}
