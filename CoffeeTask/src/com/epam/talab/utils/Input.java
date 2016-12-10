package com.epam.talab.utils;

import java.util.Scanner;



public final class Input {
/** Keyword <i>static</i> makes this a <i>class</i> oriented variable, rather than <i>object</i> oriented variable; only one instance of an <i>Input</i> object will ever exist, and the instance is tracked by this reference
variable. */
private static Input referenceToSingleInputObject = null;
/** Object-oriented instance variable, but since only one <i>Input</i> can ever be created, only one <i>Scanner</i> object will ever be created. */
private Scanner scannerKeyboard;

private Input() { scannerKeyboard = new Scanner(System.in); }

public static Input getInstance() {
if (referenceToSingleInputObject == null)
referenceToSingleInputObject = new Input();
return referenceToSingleInputObject;
 } 

public int getInt(String sPrompt) {
 System.out.print(sPrompt);
while ( ! scannerKeyboard.hasNextInt()) { 
 System.out.println("Number is required input.");
 System.out.print(sPrompt);
scannerKeyboard.nextLine(); 
 }
return scannerKeyboard.nextInt();
 } 

public double getDouble(String sPrompt) {
	 System.out.print(sPrompt);
	while ( ! scannerKeyboard.hasNextDouble()) { 
	 System.out.println("Number is required input.");
	 System.out.print(sPrompt);
	scannerKeyboard.nextLine(); 
	 }
	return scannerKeyboard.nextDouble();
	 } 

public static Input initialize(){
	Input userChoice=Input.getInstance();
	return userChoice;
}

public String getString(String sPrompt) {
	 System.out.print(sPrompt);
	scannerKeyboard.useDelimiter("\r\n"); 
	 String sInput = scannerKeyboard.next();
	scannerKeyboard.reset(); 
	return sInput;
	 }


}



