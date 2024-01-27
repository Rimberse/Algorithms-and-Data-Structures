package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class Anagram {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_d.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String s1 = scanner.next();
		String s2 = scanner.next();
		
		if (areAnagrams(s1, s2)) {
			writer.writeln("YES");
		} else {
			writer.writeln("NO");
		}
		
		scanner.close();
		writer.close();
	}
	
	public static boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		int[] letterCount = new int[26];
		
		for (int i = 0; i < s1.length(); i++) {
			letterCount[s1.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			if (letterCount[s2.charAt(i) - 'a'] == 0)
				return false;
			
			letterCount[s2.charAt(i) - 'a']--;
		}
		
		return true;
	}
}
