package com.shipcom.ecc.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shipcom.ecc.demo.color.ColorBandService;
import com.shipcom.ecc.demo.multiplier.MultiplierService;

/**
 * Calculator Class for calculating resistance for 4 and 5 Bands Resistors.
 */
@Component
public class Calculator implements IOhmValueCalculator {

	@Autowired
	ColorBandService colorBandService;

	@Autowired
	MultiplierService multiplierService;

	/**
	 * This function can calculate resistance for 4 and 5 colors.
	 * @param colors
	 * @return baseOhmValue
	 */
	@Override
	public double CalculateOhmValue(String bandAColor, String bandBColor, String bandCColor, String bandDColor) {

		int band1, band2, band3 = 0;
		double multiplier;
		double baseOhmValue;

		band1 = colorBandService.getColor(bandAColor).get(0).getValue();
		band2 = colorBandService.getColor(bandBColor).get(0).getValue();
		multiplier = multiplierService.getMultiplier(bandDColor).get(0).getValue();

		// Check if 5 band resistor
		if (bandCColor != null) {
			band3 = colorBandService.getColor(bandCColor).get(0).getValue();
			baseOhmValue = ((band1 * 100) + (band2 * 10) + (band3)) * multiplier;
		}

		baseOhmValue = ((band1 * 10) + band2) * multiplier;

		return baseOhmValue;
	}

	 /**
     * Convert double Ohm value to Ω, KΩ, MΩ or GΩ value.
     *
     * @param value Ohm value
     * @return Ohm value as Ω, KΩ, MΩ or GΩ
     */
	public String toOhmString(Double value) {
		if (value == null) {
			return "";
		} else if (value >= 1000000000) {
			return roundIfPossible(value / 1000000000) + "G";
		} else if (value >= 1000000) {
			return roundIfPossible(value / 1000000) + "M";
		} else if (value >= 1000) {
			return roundIfPossible(value / 1000) + "K";
		} else {
			return roundIfPossible(value);
		}
	}

	/**
     * Convert double to rounded value if there are no decimals.
     *
     * @param value Double value
     * @return String value, eg. "4" for input "4.4", or "4.4" for input "4.4"
     */
	public static String roundIfPossible(Double value) {
		if (value == null) {
			return "";
		} else if (value - (int) (double) value == 0) {
			return String.valueOf(Math.round(value));
		} else {
			return String.valueOf(value);
		}
	}
}
