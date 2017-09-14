package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudWeb2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWeb2Application.class, args);
    }
}
