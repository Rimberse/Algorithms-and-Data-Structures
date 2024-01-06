package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class AddTwoFractions {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_b.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		
        int commonDenominator = b * d;
        int numerator = a * (commonDenominator / b) + c * (commonDenominator / d);
        int gcd = gcd(numerator, commonDenominator);
        numerator /= gcd;
        commonDenominator /= gcd;
		
		writer.writeln(numerator + " " + commonDenominator);
		scanner.close();
		writer.close();
	}
	
	public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
