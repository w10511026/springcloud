package com.example;

import com.example.core.ApplicationConfig;
import com.example.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringcloudServiceApplication.class)
public class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    public void testApplication() {
        Object redisTemplate = ApplicationConfig.getBean("redisTemplate");
        System.out.println(redisTemplate);
    }

    @Test
    public void masterTest() {
        String master = demoService.getUserById(2222L);
        System.out.println(master);
    }

}
