package ex.api.system.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ex.api.system.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
		// UTILIZAÇÃO DE QUERY METHODS
// NOTAÇÃO QUERY PARA BUSCA DE DADOS NO MONGODB
	//	CAMPO DE BUSCA, EXPRESSÃO REGULAR, CAMELCASE (IGNORA MAIUCUSLA E MINUSCULA)
	@Query("{'title': {$regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
 // TESTANDO CAMPO DATE PASSANDO OS VALORES 1 E 2, 
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
