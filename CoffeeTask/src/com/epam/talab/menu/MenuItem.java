package com.epam.talab.menu;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.talab.utils.Input;



public abstract class MenuItem implements Executable {
	protected Input userInput=Input.getInstance();
	protected static Logger log = Logger.getLogger(MenuItem.class.getName());
	public static void initLogger()
	{
		PropertyConfigurator.configure("log4j2.properties");
	}
	
	

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub

	}

	
}
