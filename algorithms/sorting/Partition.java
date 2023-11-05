package sorting;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class Partition {
	public static void main(String[] args) {
		File file = new File("sorting_input_a.txt");
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
        
        int pivot = scanner.nextInt();
		
		int result = partition(array, 0, n - 1, pivot);
		writer.writeln(result + "\n" + (n - result));
		scanner.close();
		writer.close();
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int partition(int[] array, int left, int right, int pivot) {
		int index = left;
		
		while (left <= right) {
			if (array[left] < pivot)
				swap(array, index++, left++);
			else if (array[left] > pivot)
				swap(array, left, right--);
            else
                left++;
		}
		
		return index;
	}
}
