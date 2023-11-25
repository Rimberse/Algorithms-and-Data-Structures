package sorting;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class QuickSort {
	public static void main(String[] args) {
		File file = new File("sorting_input_b.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//      OptimizedScanner scanner = new OptimizedScanner();
		int n = scanner.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
		
		quickSort(array, 0, n - 1);
		writer.writelnArray(array);
		scanner.close();
		writer.close();
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int partition(int[] array, int left, int right) { 
	    int randomIndex = (left) + (int) (Math.random() * (right - left + 1));
	    swap(array, left, randomIndex);
	    int pivot = array[left];

        while (true) {
            while (array[left] < pivot)
            	left++;

            while (array[right] > pivot)
            	right--;

            if (left >= right)
                return right;

            swap(array, left++, right--);
        }
	}
	
	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int index = partition(array, left, right);
			quickSort(array, left, index);
			quickSort(array, index + 1, right);
		}
	}
}
