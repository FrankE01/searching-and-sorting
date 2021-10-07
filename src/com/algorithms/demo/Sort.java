package com.algorithms.demo;

import java.util.Arrays;

public class Sort extends Algorithm{
	private int[] resultArray;
	private String[] algorithmList = {"Selection Sort", "Bubble Sort", "Recursive Bubble Sort", "Insertion Sort"};
	
	public Sort() {
		this.setAlgorithms(this.algorithmList);
	}

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
	
	int[] recursiveInsertionSort(int[] arr, int key, int arrLength) {
		arrLength = arr.length;
	}
	
	
	
	void setIntResult(int[] result) {
		this.resultArray = result;
	}

	void displayResult() {
		System.out.println("Sorted Array: " + Arrays.toString(resultArray));
	}
}
