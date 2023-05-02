package com.julianocarpes.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.julianocarpes.springmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
