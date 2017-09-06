package com.example.service;

import com.example.domain.User;
import com.example.nosql.DemoMongoRepository;
import com.example.nosql.DemoRedis;
import com.example.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoRedis demoRedis;
    @Autowired
    DemoMongoRepository userDemoMongoRepository;
    @Autowired
    DemoRepository demoRepository;

    @Cacheable(value = "mysql:getUserById:user", keyGenerator = "simpleKey")
    public String getUserById(Long id) {
        User user = demoRedis.get(String.valueOf(id));
        if (null == user) {
            User one = demoRepository.findUserById(id);
            demoRedis.add(String.valueOf(id), 10000l, one);
        }
        return "hello world";
    }

    public void redis() {
        User user = new User();
        user.setId(1111L);
        user.setName("zhangsan");
        demoRedis.add(this.getClass().getName(), 10000l, user);
        User user1 = demoRedis.get(this.getClass().getName());
        System.out.println(user1);
    }

    public void mongo() {
        User user = new User();
        user.setId(1111L);
        user.setName("zhangsan");
        userDemoMongoRepository.save(user);
    }

}
