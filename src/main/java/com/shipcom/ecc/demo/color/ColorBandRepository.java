package com.shipcom.ecc.demo.color;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ColorBandRepository extends CrudRepository<ColorBand, Integer> {

	public List<ColorBand> findByColor(String color);
}
