package ex.api.system.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.api.system.domain.User;
import ex.api.system.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserRosource {
	
	@Autowired
	private UserService userSevice;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userSevice.finAll();
		return ResponseEntity.ok().body(list);
	}
}
