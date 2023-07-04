package ex.api.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		/*
		 	SERVIDOR TOMCAT IMPLEMENTADO DENTRO DO SPRING BOOT
		 	AO INICIAR ELE IRA CRIAR UMA PORTA NO 8080
		 	NO RESOUCE/PROPERTIES TEM spring.data.mongodb.uri=mongodb://localhost:27017/api
		 							SPRING FAZ REQUISIÇÃO DENTRO DO MONGODB QUE PUXA A URI DO SERVIDOR
		 								QUE FOI PASSADO A URL
		 	CONEXÃO COM BANCO DE DADOS
		 */
		
		// ADICIONA AS DEPENDENCIAS PARA O BANCO DE DADOS
	}

}
