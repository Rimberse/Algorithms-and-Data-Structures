package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class GroupProject {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_j.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if (canFormGroups(n, a, b)) {
				writer.writeln("YES");
			} else {
				writer.writeln("NO");
			}
		}

		scanner.close();
		writer.close();
	}
	
	public static boolean canFormGroups(int total, int min, int max) {
		if (total % min == 0 || total % max == 0)
			return true;
		
		return Math.ceil((double) total / (double) max) <= Math.floor((double) total / (double) min);
	}
}
