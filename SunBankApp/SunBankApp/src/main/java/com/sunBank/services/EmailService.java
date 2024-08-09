package com.sunBank.services;

import com.sunBank.dtos.EmailDetails;
import com.sunBank.dtos.OtpDto;
import com.sunBank.dtos.OtpRequestDto;

public interface EmailService {
	
	void sendEmailAlert(EmailDetails emailDetails);
	
	void sendEmailwithAttachment(EmailDetails emailDetails);
	
	OtpDto getOTP(OtpRequestDto otpRequestDto);
}
