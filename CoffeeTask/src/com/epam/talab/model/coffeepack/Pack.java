package com.epam.talab.model.coffeepack;

import java.io.Serializable;

import com.epam.talab.model.Item;
import com.epam.talab.model.coffee.Coffee;

public class Pack implements Item,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coffee coffee;
	private PackSize size;
    private	PackType pack;
    private double weight;
    private double price;
	public Pack(Coffee coffee, PackType pack, PackSize size) {
		super();
		this.coffee = coffee;
		this.pack = pack;
		this.size = size;
		this.weight = (double)coffee.getDensity()*size.getVolumeOfCoffee();
		this.price = coffee.getPrice()*this.weight;
	}
	
	public Coffee getCoffee() {
		return coffee;
	}
	
	public double getPrice() {
		return price;
	}
    
	public double getVolume(){
		return size.getVolume();
	}
	
	public Double priceToWeightRatio(){
		return (double)price/weight;
	}

	
	
	

	@Override
	public String toString() {
		return " [coffee=" + coffee + ", size=" + size.getVolumeOfCoffee() + ", pack=" + pack + ", weight=" + weight + "grams, price="
				+ price + ", price/weight="+priceToWeightRatio()+ "]";
	}

	
	
}