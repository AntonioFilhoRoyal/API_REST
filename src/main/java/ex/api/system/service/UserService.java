package ex.api.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.api.system.domain.User;
import ex.api.system.dto.UserDTO;
import ex.api.system.repositories.UserRepository;
import ex.api.system.service.exceptions.ObjectNotFoundException;

// DIFININDO QUE A CLASS É UM SERVIÇO
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
// PUZANDO UM METODO DO REPOSITORIO DO MONGO E IMPLEMENTANDO NO SERVICE	
	public List<User> finAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
											// SE NÃO TIVE O ID PASSADO ELE IRA PASSA A MENSAGEM DE ERROR
	}
	
	// CRIANDO METODO DE INSERÇÃO PARA O BANCO DE DADOS
	public User insert(User obj) {
				// PASSANDO UM OBJETO DO TIPO USER
		return userRepository.insert(obj);
	}
	
// CRIAÇÃO DE UMA INSTANCIAÇÃO PASSANDO UM OBJETO DO TIPO USERDTO QUE SERA USADO NA CLASS USERRESOURCE	
	public User fromDTO(UserDTO objDto) {
			// OBJETO TIPO USERDTO
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
	public void delete(String id) {
	// FAZENDO REQUISIÇÃO DE UM USER PELO ID	
		findById(id);
		userRepository.deleteById(id); // DELETANDO...
	}
	
	// ATUALIZANDO USER
	public User update(User obj) {
		// INSTANCIANDO UM NOVO USER
		User newObj = findById(obj.getId());
		// SIMILAR AO REPLACE, COPIA OS DADOS DO OBJ PAR AO NEWOBJ
		updateData(newObj, obj);
		return userRepository.save(newObj); // SALVANDO OS DADOS DO NEWOBJ NO BANCO DE DADOS
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
