package br.dev.tsantana.payroll_api.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.dev.tsantana.payroll_api.dto.UserDTO;

@Component
@FeignClient(name = "user-api")
public interface UserFeign {

	
	@GetMapping(value = "/api/users/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id);
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll();
}
