package ex.api.system.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ex.api.system.domain.User;

// DEFININDO QUE A CLASS É UM RESPOSITORIO
@Repository						// UMA EXTENSÃO DO MONGOREPOSITORY<TIPO DA CLASS, TIPO DO ID>
public interface UserRepository extends MongoRepository<User, String>{

}
