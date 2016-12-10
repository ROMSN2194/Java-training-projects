package com.epam.talab.model.coffeepack;

public enum PackType {
	JAR(1),
	PACKET(2);
	private int packCode;
	private PackType(int packCode) {
		this.setPackCode(packCode);
	}
	public int getPackCode() {
		return packCode;
	}
	public void setPackCode(int packCode) {
		this.packCode = packCode;
	}

	
	
}
