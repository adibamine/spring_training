package com.example.demo2.beans;

import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserService userService = appContext.getBean(UserService.class);
        userService.createUSer("toto","test",new File(""));
    }
}
