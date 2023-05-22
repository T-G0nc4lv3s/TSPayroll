package br.dev.tsantana.user_api.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.tsantana.user_api.domain.User;
import br.dev.tsantana.user_api.resources.UserResource;
import br.dev.tsantana.user_api.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {
	
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<User> findById(Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok(list);
	}

}
