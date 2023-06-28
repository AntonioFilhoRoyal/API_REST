package ex.api.system.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.api.system.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserRosource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User silva = new User(null, "Maria Silva", "maria@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, silva));
		return ResponseEntity.ok().body(list);
	}
}
