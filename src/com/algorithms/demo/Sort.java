package com.algorithms.demo;

import java.util.Arrays;

public class Sort extends Algorithm{
	private int[] resultArray;
	private String[] algorithmList = {"Selection Sort ", "Bubble Sort "};
	
	public Sort() {
		this.setAlgorithms(this.algorithmList);
	}

	int[] selectionSort(int arr[], int key) {
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
	
	int[] bubbleSort(int arr[], int key) {
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
	
	void setIntResult(int[] result) {
		this.resultArray = result;
	}

	void displayResult() {
//		System.out.print("Sorted array: [");
//		for (int i = 0; i < this.resultArray.length; i++) {
//			if(i == this.resultArray.length-1) {
//				System.out.print(this.resultArray[i]);
//			} else {
//				System.out.print(this.resultArray[i]+", ");
//			}
//		}
//		System.out.println("]");
		System.out.println("Sorted Array: " + Arrays.toString(resultArray));
	}
}
