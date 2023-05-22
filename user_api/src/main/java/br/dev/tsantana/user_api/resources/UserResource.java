package br.dev.tsantana.user_api.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.dev.tsantana.user_api.domain.User;

public interface UserResource {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id);
	
	@GetMapping
	public ResponseEntity<List<User>> findAll();
}
