package com.algorithms.demo;

import java.util.Arrays;

//A class for the sort algorithms
public class Sort{
	private int[] resultArray;
	private String[] algorithmList = {"Selection Sort", "Bubble Sort", "Recursive Bubble Sort", "Insertion Sort"};
	
	//a method to return the list of all implemented search algorithms
	String[] getAlgorithms(){
		return this.algorithmList;
	}

	
	//a method that implements the selection sort algorithm
	int[] selectionSort(int[] arr, int key) {
		int arrEnd = arr.length - 1;
		
		for(int i = 0; i < arrEnd; i++) {
			int first = i;
			for(int j = i+1; j < arr.length; j++) {
				if((key == 1) && (arr[j] < arr[first])) first = j;
				if((key == 2) && (arr[j] > arr[first])) first = j;
				
			}
			
			int temp = arr[first];
			arr[first] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	
	//a method that implements the bubble sort algorithm
	int[] bubbleSort(int[] arr, int key) {
		int arrEnd = arr.length - 1;
		for(int i = 0; i < arrEnd; i++) {
			for(int j = 0; j < arrEnd-i; j++) {
				if((key == 1) && (arr[j] > arr[j+1])) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				if((key == 2) && (arr[j] < arr[j+1])) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	
	//a method that implements the recursive bubble sort algorithm
	int[] recursiveBubbleSort(int[] arr, int key, int arrLength)  {
		if(arrLength == 1) return arr;
		
		for (int i = 0; i < arrLength - 1; i++) {
			if ((key == 1) && (arr[i] > arr[i+1])) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			if ((key == 2) && (arr[i] < arr[i+1])) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		recursiveBubbleSort(arr, key, arrLength-1);
		return arr;
	}
	
	
	//a method that implements the insertion sort algorithm
	int[] insertionSort(int[] arr, int key) {
		for(int i = 1; i < arr.length; ++i) {
			int currentItem = arr[i];
			int j = i - 1;
			if (key == 1) {
				while(j >= 0 && arr[j] > currentItem) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = currentItem;
			}
			if (key == 2) {
				while(j >= 0 && arr[j] < currentItem) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = currentItem;
			}
		}
		return arr;
	}
	
	
	//a method that displays the list of algorithms
	void displayList(String[] algorithmList) {
		for(int i = 0; i < algorithmList.length; i++) {
			System.out.println((i + 1)+". "+ algorithmList[i]);
		}
		System.out.print(">: ");
	}
	
	//a method that sets the result of algorithm operations to the resultArray field in the sort class.
	void setIntResult(int[] result) {
		this.resultArray = result;
	}

	//a method to display the result
	void displayResult() {
		System.out.println("Sorted Array: " + Arrays.toString(resultArray));
	}
}
