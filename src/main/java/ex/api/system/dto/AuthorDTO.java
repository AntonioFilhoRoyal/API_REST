package ex.api.system.dto;

import java.io.Serializable;

import ex.api.system.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
		// PROJEÇÃO DE DADOS, USADO NO POST E COMENTARIOS
	
	public AuthorDTO() {
		
	}

	public AuthorDTO(User user) {
		super();
		id = user.getId();
		name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
