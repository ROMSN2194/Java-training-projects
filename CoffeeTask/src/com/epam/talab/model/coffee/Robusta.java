package com.epam.talab.model.coffee;

public class Robusta extends Coffee {
 
	
	public Robusta( double priceperGram, Condition condition,String manufacturer) {
		super( priceperGram,condition, manufacturer);
		setCoffeineRate(0.6);
	}
	
	

}
