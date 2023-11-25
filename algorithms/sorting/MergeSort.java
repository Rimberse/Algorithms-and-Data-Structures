package sorting;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class MergeSort {
	public static void main(String[] args) {
		File file = new File("sorting_input_d.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//        OptimizedScanner scanner = new OptimizedScanner();
		int n = scanner.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
		
		mergeSort(array, 0, array.length - 1);
		writer.writelnArray(array);
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
		
		int leftIndex = 0, rightIndex = 0, index = left;
		
		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (leftArray[leftIndex] <= rightArray[rightIndex])
				array[index++] = leftArray[leftIndex++];
			else
				array[index++] = rightArray[rightIndex++];
		}
		
		while (leftIndex < leftSize)
			array[index++] = leftArray[leftIndex++];
		
		while (rightIndex < rightSize)
			array[index++] = rightArray[rightIndex++];
	}
	
	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
}
