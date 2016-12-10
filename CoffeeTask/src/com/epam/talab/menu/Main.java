package com.epam.talab.menu;

import java.util.HashMap;
import java.util.Map;

import com.epam.talab.utils.Input;

public class Main extends MenuItem{

	private static Input userInput=Input.getInstance();
		public void execute() {
		MenuItem.initLogger();
		Map <Integer,MenuItem> menuList=new HashMap<Integer,MenuItem>();
		menuList.put(1,new FromFile());
		menuList.put(2, new FromKeyBoard());
		menuList.put(3, new Exit());
		for (Integer key : menuList.keySet()) 
		    System.out.println(""+key+"-"+menuList.get(key));
		    
		    int itemNumber=userInput.getInt("Your input");
		    try{
		    	if(itemNumber>menuList.size()||itemNumber<=0) throw new Exception("Illegal user choice");
		    	menuList.get(itemNumber).execute();
		    }catch(Exception ex){
		    	log.error(ex.getMessage());
		        execute();
				// TODO Auto-generated catch block
			
	}

}

	public static void main(String[] args) {
		Main main=new Main();
		while(true){
			try{
			main.execute();
			}catch(Exception ex){
				
			}
		}
	}
}