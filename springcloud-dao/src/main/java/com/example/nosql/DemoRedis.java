package com.example.nosql;

import com.example.domain.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangshuo
 * @Description:
 * @Package com.example.repository
 * @date 2017/8/7 15:35
 */
@Repository
public class DemoRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    public void add(String key, Long time, User user) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.MINUTES);
    }

    public void add(String key, Long time, List<User> user) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.MINUTES);
    }

    public User get(String key) {
        Gson gson = new Gson();
        String listJson = (String) redisTemplate.opsForValue().get(key);
        User user = gson.fromJson(listJson, User.class);
        return user;
    }

}
