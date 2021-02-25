package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    FileAttached fileAttached;
    public void send(String email,String message){
        System.out.println("send messgae :"+message+" to "+email);
        fileAttached.toAttach();
    }
}
