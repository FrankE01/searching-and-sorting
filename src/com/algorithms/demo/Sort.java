package com.algorithms.demo;

import java.util.Arrays;
import java.util.stream.IntStream;

//A class for the sort algorithms
public class Sort{
	private int[] resultArray;
	private String[] algorithmList = {
			"Selection Sort", 
			"Bubble Sort", 
			"Recursive Bubble Sort", 
			"Insertion Sort", 
			"Merge Sort", 
			"Quick Sort",
			"Shell Sort",
			"Radix Sort"
			};
	
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
	
	
	//a method that implements the merge sort algorithm
	void merge(int[] a, int[] l, int[] r, int left, int right) {
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l[i] <= r[j]) {
	            a[k++] = l[i++];
	        }
	        else {
	            a[k++] = r[j++];
	        }
	    }
	    while (i < left) {
	        a[k++] = l[i++];
	    }
	    while (j < right) {
	        a[k++] = r[j++];
	    }
	}
	
	int[] mergeSort(int[] arr, int n, Sort sort, int key) {
	    if(n >= 2) {
		    int mid = n / 2;
		    int[] l = new int[mid];
		    int[] r = new int[n - mid];
		
		    for (int i = 0; i < mid; i++) {
		        l[i] = arr[i];
		    }
		    for (int i = mid; i < n; i++) {
		        r[i - mid] = arr[i];
		    }
		    mergeSort(l, mid, sort, key);
		    mergeSort(r, n - mid, sort, key);
		
		    merge(arr, l, r, mid, n - mid);
	    }
	    if(key == 1) {
	    	return arr;
	    } else {
	    	return IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
	    }
	}

	
	//a method that implements the quick sort algorithm
	int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	public int[] quickSort(int arr[], int begin, int end, Sort sort, int key) {
	    if (begin < end) {
	        int partitionIndex = sort.partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1, sort, key);
	        quickSort(arr, partitionIndex+1, end, sort, key);
	    }
	    if(key == 1) {
	    	return arr;
	    } else {
	    	return IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
	    }
	}
	
	
	//a method that implements the shell sort algorithm
	int[] shellSort(int arr[], int key) {
	    int n = arr.length;

	    for (int gap = n / 2; gap > 0; gap /= 2) {
	        for (int i = gap; i < n; i++) {
	            int k = arr[i];
	            int j = i;
	            while (j >= gap && arr[j - gap] > k) {
	                arr[j] = arr[j - gap];
	                j -= gap;
	            }
	            arr[j] = k;
	        }
	    }
	    if(key == 1) {
	    	return arr;
	    } else {
	    	return IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
	    }
	}
	
	
	//a method that implements the radix sort algorithm
	int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    void countSort(int arr[], int n, int exp){
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    int[] radixsort(int arr[], int n, Sort sort, int key){
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10) sort.countSort(arr, n, exp);
        if(key == 1) {
	    	return arr;
	    } else {
	    	return IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
	    }
        
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
