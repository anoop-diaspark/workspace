package com.diaspark.country.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.MappingException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.diaspark.country.countrydto.SendMailDTO;



@Service
public class mailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public void MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public void sendEmail(SendMailDTO sendMailDTO) throws MappingException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(sendMailDTO.getToAddress());
		mail.setSubject(sendMailDTO.getSubject());
		mail.setText(sendMailDTO.getQueries());

		/*
		 * This sendQuery() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
}
