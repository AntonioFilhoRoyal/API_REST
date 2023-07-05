package ex.api.system.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ex.api.system.domain.Post;
import ex.api.system.resources.util.URL;
import ex.api.system.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostRosource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
// RETORNA O POST PELO TITULO	
	@GetMapping(value = "/titlesearch")
										// O PARAMETRO DE BUSCA É DO VALOR TEXTO, PASSANDO UM TIPO TEXTO
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
					// AO PASSA O TIPO DO PARAMETRO DE NAVEGAÇÃO E O TIPO DO PARAMETRO, ELE E DECODIFICADO EM UTF-8
		text = URL.decodeParam(text); // DECODIFICA O TEXTO DO PARAMETRO, ANALISA E FAZENDO A BUSCA DENTRO DOS POST
		List<Post> list = postService.findByTitle(text); // RETORNA O POST COM TITULO DO PARAMETRO
		return ResponseEntity.ok().body(list); // RETORNA A LISTA DE POST CASO HOUVE MAIS DE UM POST
	}
	
// PESQUISA TODO TIPO DE NAVEGAÇÃO DE UM POST, TITLE E DATE	
	@GetMapping(value="/fullsearch") // CODIGO MAIS APROFUNDADO
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
