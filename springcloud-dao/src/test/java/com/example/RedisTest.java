package com.example;

import com.example.domain.User;
import com.example.nosql.DemoMongoRepository;
import com.example.nosql.DemoRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringCloudDaoApplication.class)
public class RedisTest {

    @Autowired
    DemoRedis demoRedis;
    @Autowired
    DemoMongoRepository demoMongoRepository;

    @Test
    public void testMango() {
        User user = new User();
        user.setId(UUID.randomUUID().timestamp());
        user.setName("111");
        demoMongoRepository.insert(user);
        List<User> all = demoMongoRepository.findAll();
        for (User user1 : all) {
            System.out.println(user1.getName());
        }
    }

    @Test
    public void testRedis() {
        User user2 = demoRedis.get("1");
        System.out.println(user2);
    }
}
