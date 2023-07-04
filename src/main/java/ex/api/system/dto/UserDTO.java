package ex.api.system.dto;

import ex.api.system.domain.User;

	/*
	 	MASCARANDO OS DADOS DO USERS
	 	OTIMIZA A UTILIZAÇÃO DO SISTEMA
	 	ESCONDE INFORMAÇÕES IMPORTANTES QUE SO DEVEM SE VISTA POR PESSOAS AUTORIZADAS
	 	FAZ UMA COPIA DE USERS PARA MELHORA O DESENVOLVIMENTO E NAO PUXA DIRETAMENTE DO USER, FAZENDO ASSIM A SEGURANÇA
	 	E A MELHORA DO CODIGO
	  */

		// AQUI ELE PROTEGE A SENHA, PUXANDO APENAS O ID, NAME E EMAIL
	
public class UserDTO {
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {
		
	}
		// PASSANDO UM USER NO PARAMETRO
	public UserDTO(User dto) {
	// PUXANDO OS DADOS DE DENTRO DO USER
		
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
