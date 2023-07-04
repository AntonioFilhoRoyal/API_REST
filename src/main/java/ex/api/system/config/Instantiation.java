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
import ex.api.system.dto.CommentDTO;
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
		//DELETENADO TUDO ANTES DE ADICIONA E RODAR O SISTEMA
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		// FORMATAÇÃO DA DATA
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
// CRIANDO USERS PARA TESTAR O SISTEMA		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); // SALVANDO VARIAS INSTANCIAS DE USERS
// AO USA SAVELL PASSANDO UM ARRAYS.ASLIST, A LINHA DE CODIGO SALVA TODOS OS USERS PASSADO DENTRO DELE
		// SEM PRECISA SALVA UM POR UM
		
		Post p1 = new Post(null, sdf.parse("10/05/2022"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));
		Post p2 = new Post(null, sdf.parse("21/10/2023"),"Estudo", "Estudei Jenkis hoje", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		p1.getComments().add(c3);
		p2.getComments().addAll(Arrays.asList(c1, c2));

		postRepository.saveAll(Arrays.asList(p1, p2));
		
		alex.getPost().add(p1);
		maria.getPost().add(p2);
		
		userRepository.saveAll(Arrays.asList(alex, maria));
		
	}

}
