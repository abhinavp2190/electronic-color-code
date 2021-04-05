package com.shipcom.ecc.demo.multiplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplierService {

	@Autowired
	private MultiplierRepository multiplierRepository;

	public List<Multiplier> getMultiplier(String color) {
		return multiplierRepository.findByColor(color.toUpperCase());
	}

	public List<Multiplier> getAlltMultipliers() {
		List<Multiplier> multipliers = new ArrayList<>();
		multiplierRepository.findAll().forEach(multipliers::add);

		return multipliers;
	}
}
