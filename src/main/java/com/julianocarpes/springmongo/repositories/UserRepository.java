package com.julianocarpes.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.julianocarpes.springmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
