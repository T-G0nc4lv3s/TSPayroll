package br.dev.tsantana.user_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.tsantana.user_api.domain.User;
import br.dev.tsantana.user_api.repositories.UserRepository;
import br.dev.tsantana.user_api.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	@Override
	public User findById(Long id) {
		User obj = userRepository.findById(id).orElse(null);
		return obj;
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
