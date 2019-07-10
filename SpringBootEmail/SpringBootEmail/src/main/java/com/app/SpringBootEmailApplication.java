package com.app;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import com.app.email.EmailUtil;

@SpringBootApplication
public class SpringBootEmailApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}
	@Autowired
	private EmailUtil email;
	
	@Override
	public void run(String... args) throws Exception {
		File f=new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		FileSystemResource fis=new FileSystemResource(f);
		boolean issent=email.sendEmail("javabyraghu@gmail.com", "Test Image...", "Test Image...",fis);
		System.out.println(issent);
		
		System.exit(0);
	}
}
