package ex.api.system.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ex.api.system.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

// RESPONSAVEL POR TRATA ERRORS NA REQUISIÇÕES
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
			// RESPONSE DO TIPO STANDARERROR PASSANDO O OBJECTNOFROUND E O SERVELT
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		// PUXANDO O NOT_FOUND DE UM ENUM DO HTTPSSTATUS
		HttpStatus status = HttpStatus.NOT_FOUND;
			 // CRIANDO A INSTANCIAÇÃO DO STANDARDERROR
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
					 // PASSANDO O CODIGO DE STATUS JUNTO COM O ERR PARA IMPRIMIR O ERROR
		return ResponseEntity.status(status).body(err);
	}
}
