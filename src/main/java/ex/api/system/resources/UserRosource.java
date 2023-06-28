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

import ex.api.system.domain.User;
import ex.api.system.dto.UserDTO;
import ex.api.system.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserRosource {
	
	@Autowired
	private UserService userSevice;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userSevice.finAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = userSevice.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = userSevice.fromDTO(objDto);
		obj = userSevice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		userSevice.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
 	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = userSevice.fromDTO(objDto);
		obj.setId(id);
		obj = userSevice.update(obj);
		return ResponseEntity.noContent().build();
	}
}
