package com.sunBank.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sunBank.dtos.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String senderMail;
	
	@Override
	public void sendEmailAlert(EmailDetails emailDetails) {
		
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(senderMail);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setText(emailDetails.getMessageBody());
			mailMessage.setSubject(emailDetails.getSubject());
			
			javaMailSender.send(mailMessage);
			
			System.out.println("Mail Sent Successfully...");
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

}
