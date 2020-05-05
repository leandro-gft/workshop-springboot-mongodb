package br.com.gft.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gft.workshopmongo.domain.Post;
import br.com.gft.workshopmongo.domain.User;
import br.com.gft.workshopmongo.dto.AuthorDTO;
import br.com.gft.workshopmongo.repository.PostRepository;
import br.com.gft.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User leandro = new User(null, "Leandro Sacchi", "lpsacchi@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, leandro));
		
		Post post1 = new Post(null, sdf.parse("05/05/2020"), "Partiu viagem", "Viajando para São Paulo. Abraços", new AuthorDTO(leandro) );
		Post post2 = new Post(null, sdf.parse("04/05/2020"), "Aniversário de namoro", "Hoje completo 8 anos de namoro.", new AuthorDTO(leandro));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		leandro.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(leandro);
	}

}
