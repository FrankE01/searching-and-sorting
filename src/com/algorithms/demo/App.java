/**
 * 
 */
package com.algorithms.demo;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		//Initializing all global variables
		InputScanner scanner = new InputScanner();
		boolean terminate = false;
		int suboperation = 0;
		int key = 0;
		
		//Alerting the user on how to terminate the program
		System.out.println("Type 'stop' at any point to terminate the program.");
		
		
		//using a boolean to check if user wants to terminate the program
		while(!terminate) {
			
			//getting the first operation. User has to enter a number from the menu
			//to indicate what operation is to be performed.
			System.out.println("\nWhat would you like to do?\n1. Search \n2. Sort");
			System.out.print(">: ");
			terminate = scanner.verifyInput(scanner.scanner.nextLine());
			int operation = scanner.menuSelection;
			if(terminate) break;
			
			//checking to see if the user chose a search operation and creating a Search object
			if(operation == 1) {
				Search search = new Search();
				
				//getting the sub-operation for the search and verifying the input to make sure it is in the algorithm list.
				System.out.println("Select a searching algorithm: ");
				String[] algorithmList = search.getAlgorithms();
				search.displayList(algorithmList);
				terminate = scanner.verifyInput(scanner.scanner.nextLine());
				if(terminate) break;
				if(scanner.menuSelection>algorithmList.length) {
					System.out.println("Invalid selection");
				} else {
					
					//setting the sub-operation when a valid input is given, and collecting the array elements
					//as well as search key.
					suboperation = scanner.menuSelection;
					ArrayList<Integer> workArrayList = scanner.collectInput(algorithmList, scanner, terminate, key);
					System.out.println("Enter search key: ");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					key = scanner.menuSelection;
					int[] workArray = workArrayList.stream().mapToInt(Integer::intValue).toArray();
					
					//going through switch cases for each search algorithm according to the sub-operation specified by user.
					if(suboperation == 1) {
						search.setIntResult(search.linearSearch(workArray, key));
					}
					if(suboperation == 2) {
						search.setIntResult(search.binarySearch(workArray, key, 0, workArray.length-1));
					}
					if(suboperation == 3) {
						search.setIntResult(search.exponentialSearch(workArray, key, search));
					}
					if(suboperation == 4) {
						search.setIntResult(search.fibonacciSearch(workArray, key));
					}
					search.displayResult(key);
				}
			}
			//checking to see if the user chose a sort operation and creating a Sort object
			if(operation == 2) {
				Sort sort = new Sort();
				
				//getting the sub-operation for the sort and verifying the input to make sure it is in the algorithm list.
				System.out.println("Select a sorting algorithm: ");
				String[] algorithmList = sort.getAlgorithms();
				sort.displayList(algorithmList);
				terminate = scanner.verifyInput(scanner.scanner.nextLine());
				if(terminate) break;
				if(scanner.menuSelection>algorithmList.length) {
					System.out.println("Invalid selection");
				} else {
					
					//setting the sub-operation when a valid input is given, and collecting the array elements
					//as well as sort key (ascending or non-ascending)
					suboperation = scanner.menuSelection;
					ArrayList<Integer> workArrayList = scanner.collectInput(algorithmList, scanner, terminate, key);
					System.out.println("Enter sort key: \n1. Ascending\n2. Descending");
					terminate = scanner.verifyInput(scanner.scanner.nextLine());
					if(terminate) break;
					key = scanner.menuSelection;
					int[] workArray = workArrayList.stream().mapToInt(Integer::intValue).toArray();
					
					
					//going through switch cases for each search algorithm according to the sub-operation specified by user.
					if(suboperation == 1) {
						sort.setIntResult(sort.selectionSort(workArray, key));
					}
					if(suboperation == 2) {
						sort.setIntResult(sort.bubbleSort(workArray, key));
					}
					if(suboperation == 3) {
						sort.setIntResult(sort.recursiveBubbleSort(workArray, key, workArray.length));
					}
					if(suboperation == 4) {
						sort.setIntResult(sort.insertionSort(workArray, key));
					}
					if(suboperation == 5) {
						sort.setIntResult(sort.mergeSort(workArray, workArray.length ,sort, key));
					}
					if(suboperation == 6) {
						sort.setIntResult(sort.quickSort(workArray, 0, workArray.length - 1 ,sort, key));
					}
					if(suboperation == 7) {
						sort.setIntResult(sort.shellSort(workArray, key));
					}
					if(suboperation == 8) {
						sort.setIntResult(sort.radixsort(workArray, workArray.length, sort, key));
					}
					sort.displayResult();
				}
			}
		}
		
		//closing input scanner to avoid memory leaks
		scanner.closeScanner();
	}
}

//EOF
