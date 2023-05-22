package br.dev.tsantana.user_api.services;

import java.util.List;

import br.dev.tsantana.user_api.dto.UserDTO;

public interface UserService {

	public UserDTO findById(Long id);
	
	public List<UserDTO> findAll();
}
