package br.dev.tsantana.payroll_api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.tsantana.payroll_api.domain.Payroll;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		return ResponseEntity.ok(new Payroll(
				"Bob",
				payment.getDescription(),
				payment.getHourlyPrice(),
				payment.getWorkedHours(),
				payment.getHourlyPrice() * payment.getWorkedHours()
				));
	}
}
