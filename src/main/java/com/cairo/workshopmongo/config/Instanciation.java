package com.cairo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cairo.workshopmongo.domain.Post;
import com.cairo.workshopmongo.domain.User;
import com.cairo.workshopmongo.dto.AuthorDTO;
import com.cairo.workshopmongo.repository.PostRepository;
import com.cairo.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("23/08/2018"), "Let's go traveling!", "We are going to São Paulo!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/08/2018"), "Good morning!", "I woke up happy today!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
