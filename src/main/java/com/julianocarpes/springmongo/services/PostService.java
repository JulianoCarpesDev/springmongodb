package com.julianocarpes.springmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocarpes.springmongo.domain.Post;
import com.julianocarpes.springmongo.repositories.PostRepository;
import com.julianocarpes.springmongo.services.exception.ObjectNotFoundException;

@Service

public class PostService {

	@Autowired
	private PostRepository postRepository;


	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	
}
