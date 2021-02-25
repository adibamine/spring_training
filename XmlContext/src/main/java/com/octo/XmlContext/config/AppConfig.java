package com.octo.XmlContext.config;

import com.octo.XmlContext.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmailService getEmailService(){
        return new EmailService();
    }
}
