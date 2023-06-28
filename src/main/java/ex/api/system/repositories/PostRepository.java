package ex.api.system.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ex.api.system.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTitleContainingIgnoreCase(String text);
}
