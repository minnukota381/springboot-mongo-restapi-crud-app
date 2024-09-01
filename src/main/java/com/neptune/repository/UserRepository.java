package com.neptune.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neptune.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
