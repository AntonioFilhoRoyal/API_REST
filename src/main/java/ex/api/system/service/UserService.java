package ex.api.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.api.system.domain.User;
import ex.api.system.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> finAll(){
		return userRepository.findAll();
	}
}
