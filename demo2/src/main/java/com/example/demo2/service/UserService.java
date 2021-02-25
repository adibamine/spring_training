package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class UserService {

    @Autowired
    AttachementServce attachementServce;

    public void createUSer(String nom, String prenom,File file){
        System.out.println("Create User :"+nom+" "+prenom);
        attachementServce.saveImage(file);
    }
}
