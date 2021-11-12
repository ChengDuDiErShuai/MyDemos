package com.example.mydemos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : huangjie121015
 * @date : 2021/11/11 14:04
 */
@RestController
public class HelloController {

    @GetMapping("/hello/{title}/{content}")
    public String sayHello(@PathVariable("title") String title, @PathVariable("content") String content) {
        System.out.println(title + ":" + content);
        return "hello ya~";
    }
}
