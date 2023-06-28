package ex.api.system.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ex.api.system.domain.Post;
import ex.api.system.domain.User;
import ex.api.system.dto.AuthorDTO;
import ex.api.system.repositories.PostRepository;
import ex.api.system.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("10/05/2022"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));
		Post p2 = new Post(null, sdf.parse("21/10/2023"),"Estudo", "Estudei Jenkis hoje", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
