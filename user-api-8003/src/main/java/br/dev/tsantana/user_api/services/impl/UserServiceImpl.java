package br.dev.tsantana.user_api.services.impl;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.tsantana.user_api.domain.User;
import br.dev.tsantana.user_api.dto.UserDTO;
import br.dev.tsantana.user_api.repositories.UserRepository;
import br.dev.tsantana.user_api.services.UserService;
import br.dev.tsantana.user_api.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final Environment env;
	
	@Transactional(readOnly = true)
	@Override
	public UserDTO findById(Long id) {
		log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + "port");
		User obj = userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		UserDTO dto = new UserDTO(obj);
		return dto;
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserDTO> findAll() {
		List<User> result = userRepository.findAll();
		return result.stream().map(x -> new UserDTO(x)).toList();
	}

}
