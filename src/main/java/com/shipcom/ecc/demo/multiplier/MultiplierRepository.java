package com.shipcom.ecc.demo.multiplier;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MultiplierRepository extends CrudRepository<Multiplier, Integer> {

	public List<Multiplier> findByColor(String color);
}
