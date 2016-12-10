package com.epam.talab.model;

import java.util.Map;

import com.epam.talab.model.coffeepack.Pack;

public class CoffeeFactory {
private static Pack pack;

public static Pack Factory(int num,Map <Integer,Pack> coffeeMap)
{
		    
	
	try{
		pack=coffeeMap.get(num);
	}	catch(Exception ex){
		System.out.println("Illegal choice");
	}
	return pack;
}
}