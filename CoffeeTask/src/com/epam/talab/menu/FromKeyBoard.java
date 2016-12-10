package com.epam.talab.menu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.talab.model.*;
import com.epam.talab.model.coffee.Arabica;
import com.epam.talab.model.coffee.Condition;
import com.epam.talab.model.coffee.Robusta;
import com.epam.talab.model.coffeepack.Pack;
import com.epam.talab.model.coffeepack.PackSize;
import com.epam.talab.model.coffeepack.PackType;
import com.epam.talab.utils.Input;

import com.epam.talab.utils.SortByRatio;
public class FromKeyBoard extends MenuItem {
	private Input input=Input.getInstance();
	private int coffee;
	private static Map <Integer,Pack> coffeeMap=new HashMap<Integer,Pack>();
	private static void init(){
	 
		coffeeMap.put(1, new Pack(new Arabica(0.4,Condition.GRAIN, "Jacobs"),PackType.JAR,PackSize.MEDIUM));
		coffeeMap.put(2, new Pack(new Robusta(0.4,Condition.INSTANT, "Jacobs"),PackType.PACKET,PackSize.MEDIUM));
		coffeeMap.put(3, new Pack(new Robusta(0.7,Condition.GROUND, "Galka"),PackType.PACKET,PackSize.BIG)); 
		for (Map.Entry<Integer,Pack> entry : coffeeMap.entrySet()) {
		    System.out.println(""+entry.getKey()+entry.getValue());
 }
 }

	@Override
	public String toString() {
		return "Intialization From keyboard";
	}	
	
 		@Override
		public void execute() throws Exception   {
		System.out.println("Input van capacity and available money:");
		int capacity=input.getInt("Input capacity");
		int money= input.getInt("Input money");
				Van coffeeVan=new Van(capacity,money);
		System.out.println("New Van is created with capacity:"+coffeeVan.getCapacity()+" and available money:"+coffeeVan.getAvailableMoney());
		System.out.println("Add some coffee...");
		int packsofcoffee=input.getInt("Enter ammount(number of packs):");
		if(packsofcoffee<=0) throw new IllegalArgumentException("Value must be positive");
		init();
		for(int i=0;i<packsofcoffee;i++){
			coffee=input.getInt("Select coffee:");
			try{
				if(coffee>=coffeeMap.size()) throw new NullPointerException("There is no such coffee");
			
			}catch(Exception ex){
	    	   System.out.println(ex.getMessage());
	    	   coffee=input.getInt("Please make right choice");
	       }
	       
	       coffeeVan.add(CoffeeFactory.Factory(coffee,coffeeMap));
			System.out.println("Added item");
			System.out.println(coffeeVan.get(i));
			}
		//coffeeVan.sort();
		System.out.println("Van information:\n"+coffeeVan.toString());
		// TODO Auto-generated method stub
		System.out.println("Sorted van is:");
		
		Collections.sort(coffeeVan.getProductList(),  new SortByRatio());
		
		System.out.println(coffeeVan.getProductList());
		
		
	}

}
