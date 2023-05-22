package br.dev.tsantana.user_api.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.tsantana.user_api.dto.UserDTO;
import br.dev.tsantana.user_api.resources.UserResource;
import br.dev.tsantana.user_api.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {
	
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<UserDTO> findById(Long id) {
		UserDTO dto = userService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok(list);
	}
}
