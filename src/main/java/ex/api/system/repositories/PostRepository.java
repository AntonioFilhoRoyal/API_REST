package ex.api.system.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ex.api.system.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
