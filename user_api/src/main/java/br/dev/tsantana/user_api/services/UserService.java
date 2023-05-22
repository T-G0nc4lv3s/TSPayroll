package br.dev.tsantana.user_api.services;

import java.util.List;

import br.dev.tsantana.user_api.domain.User;

public interface UserService {

	public User findById(Long id);
	
	public List<User> findAll();
}
