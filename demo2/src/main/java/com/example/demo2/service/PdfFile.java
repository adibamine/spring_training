package com.example.demo2.service;

import org.springframework.stereotype.Component;

@Component
public class PdfFile implements FileAttached{
    @Override
    public void toAttach() {
        System.out.println("PDF TO ATTACH");
    }
}
