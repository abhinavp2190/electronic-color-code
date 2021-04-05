package com.shipcom.ecc.demo.tolerance;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToleranceRepository extends CrudRepository<Tolerance, Integer> {
	public List<Tolerance> findByColor(String color);
}
