package com.example.demo2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Primary
public class AzureAttachementServiceImpl implements AttachementServce {
    @Override
    public void saveImage(File image) {
        System.out.println("Save In Azure");
    }
}
