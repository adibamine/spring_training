package com.octo.XmlContext;

import com.octo.XmlContext.config.AppConfig;
import com.octo.XmlContext.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlContextApplication {

	public static void main(String[] args) {

		//Context using XML
		SpringApplication.run(XmlContextApplication.class, args);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appConfig.xml");
		EmailService emailService = applicationContext.getBean("emailService",EmailService.class);
		emailService.send("toto@gmail.com","hello");

		//Context using Class Configuration
		//ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(AppConfig.class);
		//EmailService emailService1 = applicationContext1.getBean("emailService2",EmailService.class);
		//emailService1.send("bob@gmail.com","Hi");
	}

}
