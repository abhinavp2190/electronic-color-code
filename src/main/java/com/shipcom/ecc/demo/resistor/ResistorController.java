package com.shipcom.ecc.demo.resistor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.shipcom.ecc.demo.calculator.Calculator;
import com.shipcom.ecc.demo.tolerance.ToleranceService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ResistorController {

	@Autowired
	Calculator calculator;

	@Autowired
	ToleranceService toleranceService;

	@GetMapping("/get4band/{bandAColor}/{bandBColor}/{multiColor}/{tolColor}")
	public ResistorValue get4Band(@PathVariable("bandAColor") String bandAColor,
			@PathVariable("bandBColor") String bandBColor, @PathVariable("multiColor") String multiColor,
			@PathVariable("tolColor") String tolColor) {
		String ohm = calculator.toOhmString(calculator.CalculateOhmValue(bandAColor, bandBColor, null, multiColor));
		float tolerance = toleranceService.getTolerance(tolColor).get(0).getValue();

		return new ResistorValue(ohm, tolerance);
	}

	@GetMapping("/get5band/{bandAColor}/{bandBColor}/{bandCColor}/{multiColor}/{tolColor}")
	public ResistorValue get5Band(@PathVariable("bandAColor") String bandAColor,
			@PathVariable("bandBColor") String bandBColor, @PathVariable("bandCColor") String bandCColor,
			@PathVariable("multiColor") String multiColor, @PathVariable("tolColor") String tolColor) {

		String ohm = calculator
				.toOhmString(calculator.CalculateOhmValue(bandAColor, bandBColor, bandCColor, multiColor));
		float tolerance = toleranceService.getTolerance(tolColor).get(0).getValue();

		return new ResistorValue(ohm, tolerance);
	}

}