package com.example.controller;

import com.example.SpringbootApplication;
import com.example.domain.User;
import com.example.nosql.DemoRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class DemoRedisTest {

    @Autowired
    DemoRedis demoRedis;

    @Test
    public void get() {
        User user = demoRedis.get("1");
        System.out.println(user);
    }
}
