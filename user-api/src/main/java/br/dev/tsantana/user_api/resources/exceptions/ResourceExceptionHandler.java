package br.dev.tsantana.user_api.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.tsantana.user_api.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objctNotFound(ObjectNotFoundException err, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new StandardError(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),
						err.getMessage(), request.getRequestURI()));
	}
}
