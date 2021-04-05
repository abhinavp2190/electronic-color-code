package com.shipcom.ecc.demo.resistor;

public class ResistorValue {
	private String ohm;
	private float tolerance;

	public ResistorValue(String ohm, float tolerance) {
		this.ohm = ohm;
		this.tolerance = tolerance;
	}

	public String getOhm() {
		return ohm;
	}

	public void setOhm(String ohm) {
		this.ohm = ohm;
	}

	public float getTolerance() {
		return tolerance;
	}

	public void setTolerance(float tolerance) {
		this.tolerance = tolerance;
	}
}
