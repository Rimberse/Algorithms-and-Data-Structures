package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class CorrectBracketSequence {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_i.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String sequence = scanner.next();
		
		if (isValidBracketSequence(sequence)) {
			writer.writeln("yes");
		} else {
			writer.writeln("no");
		}

		scanner.close();
		writer.close();
	}
	
	public static boolean isValidBracketSequence(String sequence) {
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < sequence.length(); i++) {
			char brackets = sequence.charAt(i);
			
			if (brackets == '(') {
				stack.push(')');
			} else if (brackets == '[') {
				stack.push(']');
			} else if (brackets == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != brackets) {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}
