package com.algorithms.demo;

import java.util.ArrayList;
import java.util.Scanner;


//A class to handle the scanner object
public class InputScanner {
	Scanner scanner;
	int menuSelection;
	String userInput;

	//Constructor
	//scanner object is initialized 
	public InputScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	//a method to close the scanner
	void closeScanner() {
		this.scanner.close();
	}
	
	//a method to collect user input using a while loop and input scanner
	//and return an array-list of integers
	ArrayList<Integer> collectInput(String[] algorithmList, InputScanner scanner, boolean terminate, int key) {
		System.out.println("You chose: " + algorithmList[scanner.menuSelection - 1]);
		ArrayList<Integer> workArrayList = new ArrayList<Integer>();
		System.out.println("Input array elements and press return after each input. Input -1 after last array element to submit array.: ");
		while(scanner.menuSelection != -1 ) {
			terminate = scanner.verifyInput(scanner.scanner.nextLine());
			if(terminate) break;
			if(scanner.menuSelection == -1) break;
			workArrayList.add(scanner.menuSelection);
		}
		return workArrayList;
	}
	
	
	//a method to check if the user enters the stop command and otherwise sets the menuSelection field to the input as an integer.
	boolean verifyInput(String input) {
		this.userInput = input;
		if (userInput.toLowerCase().equals("stop")) {
			System.out.println("App Terminated!");
			return true;
		}else {
			try {
				this.menuSelection = Integer.parseInt(this.userInput);
			} catch(NumberFormatException e) {
				System.out.println("Invalid input");
			}
			return false;
		}
	}
}
