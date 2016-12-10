package com.epam.talab.model.coffee;

public class Liberica extends Coffee{
	private static double coffeineRate=0.6;
	
	public Liberica( double priceperGram, Condition condition,
			String manufacturer) {
		super(priceperGram, condition, manufacturer);
		
	}

}
