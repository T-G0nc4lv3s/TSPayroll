package br.dev.tsantana.payroll_api.dto;

import org.springframework.beans.BeanUtils;

import br.dev.tsantana.payroll_api.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
    
	public UserDTO(User entity) {
		BeanUtils.copyProperties(entity, this);
	}
}
