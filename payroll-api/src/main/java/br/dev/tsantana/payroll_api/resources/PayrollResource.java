package br.dev.tsantana.payroll_api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.tsantana.payroll_api.domain.Payroll;
import br.dev.tsantana.payroll_api.dto.UserDTO;
import br.dev.tsantana.payroll_api.feignClients.UserFeign;


@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {
	
	@Autowired
	private UserFeign userFeign;

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		UserDTO user = userFeign.findById(workerId).getBody();
		return ResponseEntity.ok(new Payroll(
				user.getName(),
				payment.getDescription(),
				user.getHourlyPrice(),
				payment.getWorkedHours(),
				user.getHourlyPrice() * payment.getWorkedHours()
				));
	}
}
