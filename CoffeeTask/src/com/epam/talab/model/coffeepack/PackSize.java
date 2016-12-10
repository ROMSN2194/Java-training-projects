package com.epam.talab.model.coffeepack;
import com.epam.talab.exceptions.*;


public enum PackSize  {
    
	SMALL(102,100),
	MEDIUM(255,250),
	BIG(503,500);
	private final int volume;
	private final int volumeOfCoffee;
	
	PackSize(int volume,int volumeOfCoffee) {
		try{
		if(volume<=0||volumeOfCoffee<=0) throw new IllegalValuesException("Volume must be positive value");
	    
		}catch(IllegalValuesException ex){
			System.out.println(ex.getMessage());
		}
		
		this.volume=volume;
		this.volumeOfCoffee=volumeOfCoffee;
	}

	public int getVolume() {
		return volume;
	}

	public int getVolumeOfCoffee() {
		return volumeOfCoffee;
	}
	
}

