package com.example.controller;


import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("demo")
    public String demo() {
        String user = demoService.getUserById(1111L);
        return "hello world";
    }

}
