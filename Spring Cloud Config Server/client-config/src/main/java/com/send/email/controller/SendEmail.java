package com.send.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.send.email.impl.EmailServiceImpl;

import io.micrometer.core.annotation.Timed;

@RequestMapping("/send")
@RestController
@RefreshScope
public class SendEmail {

	@Value("${email: tahirhussain7929@gmail.com}")
	private String email;

	
	@Value("${email}")
	private String myEmail; 

	@Value("${password}")
	private String myPassword; 

	
	@Value("${to.email}")
	private String toEmail; 

	
	@Value("${mail.smtp.auth}")
	private String mailSmtPauth; 
	

	@Value("${mail.smtp.starttls.enable}")
	private String mailSmtpStarttlsEnable; 

	
	@Value("${mail.smtp.host}")
	private String mailSmtpHost; 

	@Value("${mail.subject}")
	private String mailSubject;

	@Value("${mail.body}")
	private String mailBody;

	
	@Autowired
	EmailServiceImpl emailService;

	
	@GetMapping("/email")
	public String sendEmail() {
		System.out.println("Send to:"+toEmail);
			emailService.sendEmail(myEmail, toEmail, mailSubject, mailBody);
		return myEmail+" has sent message to "+toEmail;
	}
}
