package com.UserService.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private final JavaMailSender mailSender;
	public MailService(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}
	
	public void sendMail(String to,String Subject,String body) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(Subject);
		msg.setText(body);
		System.out.println(msg);
		mailSender.send(msg);
	}
}
