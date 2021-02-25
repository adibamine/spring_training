package com.example.demo2;

import com.example.demo2.confg.AppConfig;
import com.example.demo2.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmailService emailService = context.getBean(EmailService.class);
		emailService.send("toto@gmail.com","hello");

	}

}
