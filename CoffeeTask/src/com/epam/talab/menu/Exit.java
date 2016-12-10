package com.epam.talab.menu;

public class Exit extends MenuItem {

	@Override
	public String toString() {
		return "Exit";
	}
	
	public void execute(){
      System.exit(0);		
	}

}
