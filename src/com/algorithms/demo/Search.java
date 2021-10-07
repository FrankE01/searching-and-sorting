package com.algorithms.demo;

public class Search extends Algorithm{
	private int intResult = 0;
	private String[] algorithmList = {"Linear Search", "Binary Search (Sorted arrays only)"};
	
	public Search() {
		this.setAlgorithms(this.algorithmList);
	}
	
	int linearSearch(int[] arr, int key) {
		int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++)
        {
            if (arr[i] == key)
                return i;
        }
        return -1;
	}
	
	int binarySearch(int[] arr, int key, int arrayBegin, int arrayEnd) {
		if (arrayBegin > arrayEnd) {
			return -1;
		}
		int arrayMid = (arrayBegin + arrayEnd)/2;
		if (arr[arrayMid] < key) return binarySearch(arr, key, arrayBegin+1, arrayEnd);
		if(arr[arrayMid] > key) return binarySearch(arr, key, arrayBegin, arrayEnd-1);
		if(arr[arrayMid] == key) return arrayMid;
		return -1;
	}
	
	
	
	void setIntResult(int result) {
		this.intResult = result;
	}
	
	void displayResult(int key) {
		if(this.intResult == -1) {
			System.out.println("The key was not found in the array.");
		}else {
			System.out.println("The key, "+ key + " was found at index "+ this.intResult);
		}
	}
	
	
	
}
