package com.shipcom.ecc.demo.color;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ColorBandController {

	@Autowired
	ColorBandService colorBandService;

	@GetMapping("/colors")
	public List<ColorBand> getAllColors() {
		return colorBandService.getAllColors();
	}
}
