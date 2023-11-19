package sorting;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class Merging {
	public static void main(String[] args) {
		File file = new File("sorting_input_c.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//        OptimizedScanner scanner = new OptimizedScanner();
		int n = scanner.nextInt();
        int[] array1 = new int[n];
        
        for (int i = 0; i < n; i++)
            array1[i] = scanner.nextInt();
        
        n = scanner.nextInt();
        int[] array2 = new int[n];
        
        for (int i = 0; i < n; i++)
        	array2[i] = scanner.nextInt();
		
		int[] result = merge(array1, array2);
		writer.writelnArray(result);
		scanner.close();
		writer.close();
	}
	
	public static void merge(int[] array, int left, int mid, int right) {
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		
		for (int i = 0; i < leftSize; i++)
			leftArray[i] = array[left + i];
		
		for (int i = 0; i < rightSize; i++)
			rightArray[i] = array[mid + i + 1];
		
		int leftPointer = 0, rightPointer = 0;
		
		int index = left;
		while (leftPointer < leftSize && rightPointer < rightSize) {
			if (leftArray[leftPointer] <= rightArray[rightPointer])
				array[index] = leftArray[leftPointer++];
			else
				array[index] = rightArray[rightPointer++];
			
			index++;
		}
		
		while (leftPointer < leftSize)
			array[index++] = leftArray[leftPointer++];
		
		while (rightPointer < rightSize)
			array[index++] = rightArray[rightPointer++];
	}
	
	public static int[] merge(int[] array1, int[] array2) {
		int[] array = new int[array1.length + array2.length];
		int array1Pointer = 0, array2Pointer = 0;
		
		int index = 0;
		while (array1Pointer < array1.length && array2Pointer < array2.length) {
			if (array1[array1Pointer] <= array2[array2Pointer])
				array[index] = array1[array1Pointer++];
			else
				array[index] = array2[array2Pointer++];
			
			index++;
		}
		
		while (array1Pointer < array1.length)
			array[index++] = array1[array1Pointer++];
		
		while (array2Pointer < array2.length)
			array[index++] = array2[array2Pointer++];
		
		return array;
	}
	
	public static void inPlaceMerge(int[] array, int left, int mid, int right) {
		int leftPointer = left;
		int rightPointer = mid + 1;
		
		if (array[mid] <= array[rightPointer])
			return;
		
		while (leftPointer <= mid && rightPointer <= right) {
			if (array[leftPointer] <= array[rightPointer])
				leftPointer++;
			else {
				int temp = array[rightPointer];
				int index = rightPointer;
				
				while (index != leftPointer) {
					array[index] = array[index - 1];
					index--;
				}
				
				array[leftPointer] = temp;
				leftPointer++;
				mid++;
				rightPointer++;
			}
		}
	}
	
	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			inPlaceMerge(array, left, mid, right);
		}
	}
}
