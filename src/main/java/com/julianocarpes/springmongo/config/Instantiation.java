package com.julianocarpes.springmongo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.julianocarpes.springmongo.domain.Post;
import com.julianocarpes.springmongo.domain.User;
import com.julianocarpes.springmongo.dto.CommentDTO;
import com.julianocarpes.springmongo.dto.PostDTO;
import com.julianocarpes.springmongo.repositories.PostRepository;
import com.julianocarpes.springmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("02/05/2023"), "Viagem", "Indo para Paris",new PostDTO( maria));
		Post post2 = new Post(null, sdf.parse("03/05/2023"), "Em Paris", "Curtindo Paris",new PostDTO( maria));
		
		
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("02/05/2023"),new PostDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("02/05/2023"),new PostDTO(bob));
		CommentDTO c3 = new CommentDTO("Que massa!", sdf.parse("03/05/2023"),new PostDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		postRepository.saveAll(Arrays.asList(post1,post2));
		maria.getPosts().add(post1);
		maria.getPosts().add(post2);
		userRepository.save(maria);
		
		
	}

}
