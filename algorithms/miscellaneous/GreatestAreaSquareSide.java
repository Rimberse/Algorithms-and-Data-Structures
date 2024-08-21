package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class GreatestAreaSquareSide {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_g.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] field = new int[n][m];
        
        // Reading the field with carrots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = scanner.nextInt();
            }
        }

        int result = findLargestSquareSide(field, n, m);
        writer.writeln(result);

		scanner.close();
		writer.close();
	}
	
	// Function to find the side of the largest square
	private static int findLargestSquareSide(int[][] field, int n, int m) {
		// Dynamic programming matrix to store the side length of the largest square filled with carrots
        int[][] dp = new int[n][m];
        int maxSide = 0;

        // Initializing the first column of the dp matrix
        for (int i = 0; i < n; i++) {
            dp[i][0] = field[i][0];
            maxSide = Math.max(maxSide, dp[i][0]);
        }

        // Initializing the first row of the dp matrix
        for (int j = 0; j < m; j++) {
            dp[0][j] = field[0][j];
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        // Filling the dp matrix using dynamic programming
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (field[i][j] == 1) {
                	// If the current cell has a carrot, calculate the side length of the square
                    // The side length is the minimum of the values in the adjacent cells, plus 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // Update the maximum side length
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // Return the maximum side length of the square filled with carrots
        return maxSide;
    }
}
