package com.shipcom.ecc.demo.color;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorBandService {

	@Autowired
	private ColorBandRepository colorBandRepository;

	public List<ColorBand> getColor(String color) {
		return colorBandRepository.findByColor(color.toUpperCase());
	}

	public List<ColorBand> getAllColors() {
		List<ColorBand> colors = new ArrayList<>();
		colorBandRepository.findAll().forEach(colors::add);

		return colors;
	}
}
