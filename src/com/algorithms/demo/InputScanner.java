package com.algorithms.demo;

import java.util.Scanner;

public class InputScanner {
	Scanner scanner;
	int menuSelection;
	String userInput;

	public InputScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	void closeScanner() {
		this.scanner.close();
	}
	
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
