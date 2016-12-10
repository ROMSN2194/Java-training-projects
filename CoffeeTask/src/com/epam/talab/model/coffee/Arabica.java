package com.epam.talab.model.coffee;

public class Arabica extends Coffee {

	public Arabica(double priceperGram, Condition condition,
			String manufacturer) {
		super(priceperGram,condition, manufacturer);
		setCoffeineRate(0.4); // TODO Auto-generated constructor stub
	}

}
