package com.shipcom.ecc.demo.tolerance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ToleranceController {

	@Autowired
	ToleranceService toleranceService;

	@GetMapping("/tolerance")
	public List<Tolerance> getAlltTolerances() {
		return toleranceService.getAlltTolerances();
	}
}
