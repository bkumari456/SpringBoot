package com.app.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String to,String subject,String text,FileSystemResource file) {
		boolean sent=false;
		try {
			MimeMessage message=mailsender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message, file!=null?true:false);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			helper.setFrom("javaraghu2018@gmail.com");
			if(file!=null)
				helper.addAttachment(file.getFilename(), file);
			mailsender.send(message);
			sent=true;
		} catch (Exception e) {
			sent=false;
			e.printStackTrace();
		}
		return sent;
	}
}
