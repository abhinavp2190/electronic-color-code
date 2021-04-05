package com.shipcom.ecc.demo.multiplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class MultiplierController {

	@Autowired
	MultiplierService multiplierService;

	@GetMapping("/multiplier")
	public List<Multiplier> getAlltMultipliers() {
		return multiplierService.getAlltMultipliers();
	}
}
