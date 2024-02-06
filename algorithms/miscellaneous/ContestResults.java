package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class ContestResults {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_h.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int n = scanner.nextInt();
		
		if (hasMoreStudents(a, b, n)) {
			writer.writeln("YES");
		} else {
			writer.writeln("NO");
		}

		scanner.close();
		writer.close();
	}
	
	public static boolean hasMoreStudents(int group1, int group2, int problemsCount) {
		int group2Count = group2 / problemsCount;
		
		if (group2 % problemsCount != 0)
			group2Count++;
		
		return group1 > group2Count;
	}
}
