package com.shipcom.ecc.demo.tolerance;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToleranceService {

	@Autowired
	private ToleranceRepository toleranceRepository;

	public List<Tolerance> getTolerance(String color) {
		return toleranceRepository.findByColor(color.toUpperCase());
	}

	public List<Tolerance> getAlltTolerances() {
		List<Tolerance> tolerance = new ArrayList<>();
		toleranceRepository.findAll().forEach(tolerance::add);

		return tolerance;
	}
}
