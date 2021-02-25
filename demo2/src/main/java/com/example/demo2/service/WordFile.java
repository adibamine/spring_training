package com.example.demo2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WordFile implements FileAttached{
    @Override
    public void toAttach() {
        System.out.println("WORD TO ATTACH");
    }
}
