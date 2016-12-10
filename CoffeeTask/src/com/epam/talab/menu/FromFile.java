package com.epam.talab.menu;

import com.epam.talab.model.Van;

public class FromFile extends MenuItem{
	private double maximum,minimum;
  
	@Override
	public String toString() {
		return "Intialization FromFile";
	}


	@Override
	public void execute() {
		Van coffeeVan=new Van(1000,10000);
   
		coffeeVan.getProductListFromFile();
		System.out.println("Initializing from file");
		System.out.println(coffeeVan.toString());
		System.out.println("Search for coffee:1-By coffeinerate,2-By price,3-Main menu");
		switch(userInput.getInt("Your input")){
		
				case 1:{
					minimum=userInput.getDouble("Minimum value");
					maximum=userInput.getDouble("Maximum value");
					coffeeVan.findByCoffeinRate(minimum,maximum);
					System.out.println(coffeeVan.getFoundedItems().toString());
					coffeeVan.setFoundedItems(null);
					break;// TODO Auto-generated method stub
	
	}
				case 2:{
					minimum=userInput.getDouble("Minimum value");
					maximum=userInput.getDouble("Maximum value");
					coffeeVan.findByPrice(minimum,maximum);
					coffeeVan.getFoundedItems().toString();
					coffeeVan.setFoundedItems(null);
					break;
				}
				
				case 3:{
					{
						Main.main(null);
						break;
					}
				}
				default:{
					execute();
					break;
				}
		}
	
	
}
}
