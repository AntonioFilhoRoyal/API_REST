package ex.api.system.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ex.api.system.domain.Post;
import ex.api.system.domain.User;
import ex.api.system.dto.UserDTO;
import ex.api.system.service.UserService;

@RestController // AFIRMAR QUE A CLASS É UMA CLASS DE CONTROLLER
@RequestMapping(value = "/users") // NAVEGAÇÃO
public class UserRosource {
	
	@Autowired // INJETA DEPENDENCIA
	private UserService userSevice;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userSevice.finAll(); // PASSANDO O FINDALL DO SERVICE PARA O RESOURCE
		// CONVERTENDO O USER PARA USERDTO
// RECEBENDO UMA LISTA DO TIPO USERDTO COM NOME DE LISTDTO, TRANSFORMANDO EM STREAM		
											// MAPEANDO CADA ELEMTNO DA LISTA(X), INSTANCIANDO UM USERDTO
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
									// PUXANDO O COLLECT PARA PEGA O METODO TOLIST DO COLLECTORS CONVERTENDO O 
											// USERDTO PARA LISTA E IMPRIMIR NO BODY
							// IMPRIMINDO A LIST DE USERDTO
		return ResponseEntity.ok().body(listDTO);
// RETORNA UMA RESPOSTA DE ENTIDADE COM TUDO OK NO CORPO DA MINHA REQUISIÇÃO(/users)
	}
	
// BUSCANDO UM USER PELO ID	
	@GetMapping(value = "/{id}") // NAVEGAÇÃO OPCIONAL
									// ASSOCIANDO O ID DO PARAMENTRO COM O ID DE NAVEGAÇÃO
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
						// PUXANDO O FINDBYID DO SERVICE
		User user = userSevice.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
								// CONVERTENDO O USER PARA USER DTO, CRIANDO UMA INSTANCIAÇÃO
	}
	
	// ANOTAÇÃO DE POST
	@PostMapping
								// ANOTAÇÃO PARA PUXA O OBJETO DO BODY E USA COMO PARAMETRO
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
											// PASSANDO COMO PARAMETRO UM OBJETO TIPO USERDTO
		User obj = userSevice.fromDTO(objDto); // UTILIZANDO O METODO FROMDTO DO USERSERVICE
		obj = userSevice.insert(obj); // CONVERTENDO PARA OBJ E FAZE INSERÇÃO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		// CODIGO QUE FAZ O CAMINHDO DO ID PARA O /ID DO GET, PUXANDO NA URI
		return ResponseEntity.created(uri).build(); // CRIANDO O BANCO DO NOVO USERDTO E FAZENDO A CONSTRUÇÃO
	}
	
	// ANOTAÇÃO DE DELETE
	@DeleteMapping					// SIMILAR AO FINDYID, PASSANDO O ID DE NAVEGAÇAO PARA O PARAMETRO
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		userSevice.delete(id);
		return ResponseEntity.noContent().build(); // NOCONTENT NÃO RETORNA NADA, APENAS DELETA O DADO PASSADO
	}
	
	// ANOTAÇÃO DE ATUALIZAÇÃO
	@PutMapping					 // SIMILAR AO POST, PUXANDO O ID
 	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = userSevice.fromDTO(objDto); // PUXANDO O USERDTO DO FROMDTO
		obj.setId(id); // SETANDO O ID DO PARAMETRO
		obj = userSevice.update(obj); // ATUALIZANDO
		return ResponseEntity.noContent().build(); // ATUALIZANDO E CRIANDO O NOVO BANCO DE DADOS DO DADO
	}
	
	@GetMapping(value="/{id}/posts")
 	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = userSevice.findById(id);
		return ResponseEntity.ok().body(obj.getPost());
	}
}
