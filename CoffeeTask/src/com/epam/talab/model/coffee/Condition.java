package com.epam.talab.model.coffee;

public enum Condition {
INSTANT(0.1),
GRAIN(0.15),
GROUND(0.2);
	private double density;
	Condition(double density){
		this.setDensity(density);
	}
	public double getDensity() {
		return density;
	}
	public void setDensity(double density) {
		this.density = density;
	};

}
