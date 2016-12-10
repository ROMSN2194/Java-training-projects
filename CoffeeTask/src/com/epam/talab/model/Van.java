package com.epam.talab.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.talab.exceptions.IllegalValuesException;
import com.epam.talab.exceptions.ItemNotFoundException;
import com.epam.talab.exceptions.MinimumMaximumException;
import com.epam.talab.exceptions.OutOfLimitsException;
import com.epam.talab.model.coffee.Coffee;
import com.epam.talab.model.coffeepack.Pack;




public class Van  implements Serializable{
	
	static Logger log = Logger.getLogger(Van.class.getName());

	private double capacity;
	private static int operationId=0;
	
	private transient double usedCapacity;
	private transient int  availableMoney;	
	private transient double usedMoney;
	private List<Pack> productList;
	List<Pack> foundedItems=new ArrayList<Pack>();
   
	
	@Override
	public String toString() {
		return "[capacity=" + capacity + " m^3, usedCapacity=" + usedCapacity/1000000 + "m^3, availableMoney=" + availableMoney
				+ ", usedMoney=" + usedMoney + ",\n productList=" + productList + "]";
	}

	public Van(int capacity, int availableMoney) throws IllegalValuesException{
		super();
		if((capacity<=0)||(availableMoney<=0)) throw new IllegalValuesException();
		this.capacity = capacity;
		this.availableMoney = availableMoney;
		productList=new ArrayList<Pack>();
		PropertyConfigurator.configure("log4j2.properties");	
	}

	public Van(List <Pack> products,int money) throws Exception{
		this.availableMoney=money;
			for(Pack item:products){
				this.add(item);
			}
		
		
	}
	
	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(int availableMoney) {
		this.availableMoney = availableMoney;
	}

	public Van() {
		// TODO Auto-generated constructor stub
	}

	private boolean checkAvailableCapacity(){
    		
    		for(Pack item:productList){
    			usedCapacity+=item.getVolume();
    			usedMoney+=item.getPrice();
    		}
    		
    		if((double)usedCapacity/1000000>capacity||availableMoney<=usedMoney)
    			return false;
    		    return true;
    				
	}
	
	public void add(Pack product) throws Exception{
       
		if(!checkAvailableCapacity()) throw new OutOfLimitsException("Van is crowded");
		productList.add(product);
		operationId++;
	    usedMoney+=product.getPrice();
	    log.info(operationId+" Add operation complete usedMoney:"+product.getPrice()+ " money left"+(availableMoney-usedMoney));
		 if(availableMoney<=usedMoney) throw new OutOfLimitsException("All money have been used");
	}
	
	public Pack get(int i){
		return productList.get(i);
	}
	public List<Pack> getProductList() {
		return productList;
	}

	public void setProductList(List<Pack> productList) {
		this.productList = productList;
	}

	public List<Pack> getFoundedItems() {
		return foundedItems;
	}

	public void setFoundedItems(List<Pack> foundedItems) {
		this.foundedItems = foundedItems;
	}

	public void findByPrice(double minPrice,double maxPrice){
		
        for(Pack item:productList){
        	if(minPrice<=item.getPrice()&&maxPrice>=item.getPrice()){
        	   		foundedItems.add(item);
        	
        	System.out.println(item.toString());}
        }
        if(foundedItems.isEmpty()) throw new ItemNotFoundException("There is no such coffee");
        	
	}
	
	
	
	
	public void findByCoffeinRate(double minCoffeineRate,double maxCoffeineRate) throws MinimumMaximumException{
	    if(minCoffeineRate>maxCoffeineRate) throw new MinimumMaximumException("Maximal value must be greater than minimum");
        for(Pack item:productList){
        	if(minCoffeineRate<=item.getCoffee().getCoffeineRate()&&maxCoffeineRate>=item.getCoffee().getCoffeineRate())
        		
        	{
        		
        		foundedItems.add(item);
        	}
        	
        }
      
        if(foundedItems.isEmpty()) throw new ItemNotFoundException("Ther is no such coffee");
    	  	
	}
	
	public void Output(List <Coffee> list){
		 for(Coffee item:list){
			 System.out.println(item.toString());
		 }
	}
	
	public void addProductListInFile()    {
		Van van=new Van(1000,10000);
		try{
    		FileOutputStream fileOut=new FileOutputStream("Product.dat");
    		ObjectOutputStream out=new ObjectOutputStream(fileOut);
    		out.writeObject(van.productList);
            fileOut.close();
    	
    		System.out.println("Object was serialized");
    	} catch (FileNotFoundException ex){
    		ex.printStackTrace();
    	} catch(IOException ex){
    		ex.printStackTrace();
    	}
    	
    		
    
    }
   
	public  List<Pack> getProductListFromFile()  { 
		
		try   {
			FileInputStream fileIn = new FileInputStream("Product.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			productList = (ArrayList) in.readObject();
			fileIn.close();
			in.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
       
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
        
     }
	
		for(Pack item:productList){
			usedMoney+=item.getPrice();
			usedCapacity+=item.getVolume();
		}
   return productList;
}

	
	
}
