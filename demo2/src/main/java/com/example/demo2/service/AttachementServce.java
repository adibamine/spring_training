package com.example.demo2.service;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface AttachementServce {
    void saveImage(File file);
}
