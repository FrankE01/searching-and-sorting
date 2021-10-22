package com.algorithms.demo;

//A class for the search algorithms
public class Search{
	private int intResult = 0;
	private String[] algorithmList = {
			"Linear Search", 
			"Binary Search (Sorted arrays only)", 
			"Exponential Search (Sorted arrays only)", 
			"Fibonacci Search (Sorted arrays only)"
			};
	
	//a method to return the list of all implemented search algorithms
	String[] getAlgorithms(){
		return this.algorithmList;
	}
	
	
	//a method that implements the linear search algorithm
	int linearSearch(int[] arr, int key) {
		int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++)
        {
            if (arr[i] == key)
                return i;
        }
        return -1;
	}
	
	//a method that implements the binary search algorithm
	int binarySearch(int[] arr, int key, int arrayBegin, int arrayEnd) {
		if (arrayBegin > arrayEnd) {
			return -1;
		}
		int arrayMid = (arrayBegin + arrayEnd)/2;
		if (arr[arrayMid] < key) return binarySearch(arr, key, arrayMid+1, arrayEnd);
		if(arr[arrayMid] > key) return binarySearch(arr, key, arrayBegin, arrayMid-1);
		if(arr[arrayMid] == key) return arrayMid;
		return -1;
	}
	
	
	//a method that implements the exponential search algorithm
	int exponentialSearch(int[] arr, int key, Search search) {
		if(arr[0] == key) return 0;
		
		int i = 1;
		while((i < arr.length) && (arr[i] <= key)) {
			i = i*2;	
		}
		
		return search.binarySearch(arr, key, i/2, Math.min(i, arr.length-1));
	}
	
	
	//a method that implements the fibonacci search algorithm
	int fibonacciSearch(int[] arr, int key) {
		int fib2 = 0;
		int fib1 = 1;
		int fibN = fib2 + fib1;
		
		while(fibN < arr.length) {
			fib2 = fib1;
			fib1 = fibN;
			fibN = fib2 + fib1;
		}
		
		int offset = -1;
		
		while(fibN > 1) {
			int i = ((fib2 + offset) <= arr.length-1) ? fib2 : arr.length;
			if(arr[i] < key) {
				fibN = fib1;
				fib1 = fib2;
				fib2 = fibN - fib1;
				offset = i;
			} else if(arr[i] > key) {
				fibN = fib2;
				fib1 = fib1 - fib2;
				fib2 = fibN - fib1;
			} else {
				return i;
			}
			
			
		}
		if(fib1 == 1 && arr[arr.length-1] == key) {
			return arr.length-1;
		}
		return -1;
	}
	
	
	
	//a method that displays the list of algorithms
	void displayList(String[] algorithmList) {
		for(int i = 0; i < algorithmList.length; i++) {
			System.out.println((i + 1)+". "+ algorithmList[i]);
		}
		System.out.print(">: ");
	}
	
	
	//a method that sets the result of algorithm operations to the intResult field in the search class.
	void setIntResult(int result) {
		this.intResult = result;
	}
	
	//a method to display the result
	void displayResult(int key) {
		if(this.intResult == -1) {
			System.out.println("The key was not found in the array.");
		}else {
			System.out.println("The key, "+ key + " was found at index "+ this.intResult);
		}
	}
	
	
	
}
