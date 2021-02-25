package com.example.demo2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AwsAttachementServiceImpl implements AttachementServce {
    @Override
    public void saveImage(File file) {
        System.out.println("Save In Aws");
    }
}
