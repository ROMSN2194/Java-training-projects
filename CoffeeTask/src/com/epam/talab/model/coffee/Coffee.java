package com.epam.talab.model.coffee;

import java.io.Serializable;
import java.util.Comparator;

import com.epam.talab.exceptions.IllegalValuesException;
import com.epam.talab.model.Item;



public abstract class Coffee  implements Item,Serializable{
	
	
	
	private double pricePerGram;
	private String manufacturer;
	private Condition condition;
	private   double coffeineRate;
	private double density;
	
	//protected static double coffeineRate;
	
	public Coffee(double priceperGram,Condition condition,String manufacturer) {
		super();
	    try{
	    	if(priceperGram<=0||condition==null||manufacturer==null) throw new IllegalValuesException("Values must be positive and not null");
	    }catch(IllegalValuesException ex){
	    	System.out.println(ex.getMessage());
	    	return;
	    }
	    this.pricePerGram = priceperGram;
	   	this.condition=condition;
		this.manufacturer=manufacturer;
		this.setDensity(this.condition.getDensity());
		
		
	}
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.pricePerGram;
	}
	
	public void setPrice(double price){
		this.pricePerGram=price;
	}
		 

	@Override
	public String toString() {
		return  this.getClass().getSimpleName() + ", condition=" + condition + ", priceperGram=" + pricePerGram+
				 ", manufacturer=" + manufacturer+"]";
	}
	
	public double getDensity() {
		return density;
	}
	
	public void setDensity(double density) {
		this.density = density*10;
	}

	public double getCoffeineRate() {
		return coffeineRate;
	}

	public void setCoffeineRate(double coffeineRate) {
		this.coffeineRate = coffeineRate;
	}


}
