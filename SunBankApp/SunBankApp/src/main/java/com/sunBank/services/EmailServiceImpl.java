package com.sunBank.services;


import java.io.File;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sunBank.dtos.EmailDetails;
import com.sunBank.dtos.OtpDto;
import com.sunBank.dtos.OtpRequestDto;
import com.sunBank.utils.AccountUtils;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String senderMail;
	
	// send email alert 
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
	
	// send email alert with attachment 
	@Override
	public void sendEmailwithAttachment(EmailDetails emailDetails) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try
		{
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(senderMail);
			mimeMessageHelper.setTo(emailDetails.getRecipient());
			mimeMessageHelper.setText(emailDetails.getMessageBody());
			mimeMessageHelper.setSubject(emailDetails.getSubject());
			
			FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
			mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()),file);
			
			javaMailSender.send(mimeMessage);
			
			log.info(file.getFilename()+" has been sent to user with email "+emailDetails.getRecipient());
		}catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	// get otp method 
	@Override
	public OtpDto getOTP(OtpRequestDto otpRequestDto) {
		String otp = AccountUtils.generateOTP();
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.submit(()->{
			EmailDetails emailDetails = EmailDetails.builder()
					.recipient(otpRequestDto.getEmail())
					.subject("Authentication OTP")
					.messageBody("Your OTP for Authentication: "+otp)
					.build();
			
			sendEmailAlert(emailDetails); // send the email notification 
		});
		
		// shutdown a thread 
		executorService.shutdown();
		OtpDto otpDto = new OtpDto();  // otpdto inside only one string field 
		otpDto.setOtp(otp);
		return otpDto;
	}

}
