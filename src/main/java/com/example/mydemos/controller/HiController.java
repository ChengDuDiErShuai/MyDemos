package com.example.mydemos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : huangjie121015
 * @date : 2021/11/11 14:04
 */
@RestController
public class HiController {

    @GetMapping("/hi")
    public String sayHello() {
        System.out.println("hi, good morning~");
        return "hi bro ~";
    }
}
