package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class DistinctFromMinimumOnSequence {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_a.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			writer.writeln(numberDistinctFromMin(array, start, end));
		}
		
		scanner.close();
		writer.close();
	}
	
	public static String numberDistinctFromMin(int[] array, int start, int end) {
		int min = Integer.MAX_VALUE;
		
		for (int i = start; i <= end; i++) {
			min = Math.min(array[i], min);
		}
		
		for (int i = start; i <= end; i++) {
			if (array[i] != min)
				return String.valueOf(array[i]);
		}
		
		return "NOT FOUND";
	}
}
