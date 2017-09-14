package com.example.nosql;

import com.example.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMongoRepository extends MongoRepository<User, Long> {


    User findByName(String name);
}
