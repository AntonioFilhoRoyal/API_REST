package ex.api.system.dto;

import ex.api.system.domain.User;

public class UserDTO {
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {
		
	}
	
	public UserDTO(User dto) {
		id = dto.getId();
		name = dto.getName();
		email = dto.getEmail();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
