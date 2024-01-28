package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class AverageLevel {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_e.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = scanner.nextInt();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		writer.writelnArray(calculateDissatisfaction(array));

		scanner.close();
		writer.close();
	}
	
	public static int[] calculateDissatisfaction(int[] ratings) {
		int n = ratings.length;
		int[] dissatisfaction = new int[n];

		// Prefix sum
		int sum = 0;
        for (int i = 0; i < n; i++) {
            dissatisfaction[i] = i * ratings[i] - sum;
            sum += ratings[i];
        }

        int index = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            dissatisfaction[i] += sum - index * ratings[i];
            sum += ratings[i];
            index++;
        }
        
        return dissatisfaction;
	}
}
