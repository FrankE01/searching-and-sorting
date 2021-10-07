/**
 * 
 */
package com.algorithms.demo;

/**
 * @author Francis
 *
 */
public class App {
	public static void main(String[] args) {
		
		InputScanner scanner = new InputScanner();
		boolean terminate = false;
		int arraySize = 0;
		int subop = 0;
		int key = 0;
		
		
		System.out.println("Type 'stop' at any point to terminate the program.");
		
		
		
		while(!terminate) {
			System.out.println("\nWhat would you like to do?\n1. Search \n2. Sort");
			System.out.print(">: ");
			terminate = scanner.verifyInput(scanner.scanner.nextLine());
			int operation = scanner.menuSelection;
			if(terminate) break;
			
			
			if(operation == 1) {
				Search search = new Search();
				System.out.println("Select a searching algorithm: ");
				
				String[] algorithmList = search.getAlgorithms();
				for(int i = 0; i < algorithmList.length; i++) {
					System.out.println((i + 1)+". "+ algorithmList[i]);
				}
				System.out.print(">: ");
				terminate = scanner.verifyInput(scanner.scanner.nextLine());
				if(terminate) break;
				if(scanner.menuSelection>algorithmList.length) {
					System.out.println("Invalid selection");
				} else {
					subop = scanner.menuSelection;
					System.out.println("You chose: " + algorithmList[scanner.menuSelection - 1]);
					System.out.print("Input array size: ");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					arraySize = scanner.menuSelection;
					int[] workArray = new int[arraySize];
					System.out.println("Array should have "+arraySize+" elements.\n Input array elements and press return after each input: ");
					for(int i = 0; i< arraySize; i++) {
						terminate = scanner.verifyInput(scanner.scanner.nextLine());
						if(terminate) break;
						workArray[i] = scanner.menuSelection;
					}
					if(terminate) break;
					System.out.println("Enter search key: ");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					key = scanner.menuSelection;
					
					
					if(subop == 1) {
						search.setIntResult(search.linearSearch(workArray, key));
						search.displayResult(key);
					}
					if(subop == 2) {
						search.setIntResult(search.binarySearch(workArray, key, 0, arraySize-1));
						search.displayResult(key);
					}
				}
			}
			if(operation == 2) {
				Sort sort = new Sort();
				System.out.println("Select a sorting algorithm: ");
				
				String[] algorithmList = sort.getAlgorithms();
				for(int i = 0; i < algorithmList.length; i++) {
					System.out.println((i + 1)+". "+ algorithmList[i]);
				}
				terminate = scanner.verifyInput(scanner.scanner.nextLine());
				if(terminate) break;
				if(scanner.menuSelection>algorithmList.length) {
					System.out.println("Invalid selection");
				} else {
					subop = scanner.menuSelection;
					System.out.println("You chose: " + algorithmList[scanner.menuSelection - 1]);
					System.out.print("Input array size: ");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					arraySize = scanner.menuSelection;
					int[] workArray = new int[arraySize];
					System.out.println("Array should have "+arraySize+" elements.\n Input array elements and press return after each input: ");
					for(int i = 0; i< arraySize; i++) {
						terminate = scanner.verifyInput(scanner.scanner.nextLine());
						if(terminate) break;
						workArray[i] = scanner.menuSelection;
					}
					if(terminate) break;
					System.out.println("Enter sort key: \n1. Ascending\n2. Descending");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					key = scanner.menuSelection;
					
					if(subop == 1) {
						sort.setIntResult(sort.selectionSort(workArray, key));
						sort.displayResult(key);
					}
					if(subop == 2) {
						sort.setIntResult(sort.bubbleSort(workArray, key));
						sort.displayResult(key);
					}
				}
			}
		}
		
		scanner.closeScanner();
	}
}
