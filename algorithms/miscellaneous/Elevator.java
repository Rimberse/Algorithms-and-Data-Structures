package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class Elevator {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_f.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BigInteger k = BigInteger.valueOf(scanner.nextInt());
		int n = scanner.nextInt();
		BigInteger[] array = new BigInteger[n];

		for (int i = 0; i < n; i++) {
			array[i] = BigInteger.valueOf(scanner.nextInt());
		}

		writer.writeln(calculateMinTime(array, k));

		scanner.close();
		writer.close();
	}

	// Calculates minimum number of seconds it takes for elevator to take all employees to the underground parking from all the floors of the building
	public static BigInteger calculateMinTime(BigInteger[] employees, BigInteger capacity) {
		int n = employees.length;
		BigInteger currCapacity = capacity;
		BigInteger seconds = BigInteger.ZERO;

		for (int i = n - 1; i >= 0; i--) {
			// If there are no employees on the floor, continue going down
			if (employees[i].equals(BigInteger.ZERO))
				continue;

			// When going down, an elevator can accommodate more employees, if capacity hasn't been reached
			if (!currCapacity.equals(capacity)) {
				if (employees[i].subtract(currCapacity).compareTo(BigInteger.ZERO) < 0) {
					currCapacity = currCapacity.subtract(employees[i]);
					continue;
				} else if (employees[i].subtract(currCapacity).equals(BigInteger.ZERO)) {
					currCapacity = capacity;
					continue;
				} else {
					employees[i] = employees[i].subtract(currCapacity);
					currCapacity = capacity;
				}
			}

			// Seconds: number of trips to reach floor and go to the underground * floor * going up and down
			seconds = seconds.add(
						employees[i].divide(currCapacity)
						.multiply(BigInteger.valueOf(i + 1))
						.multiply(BigInteger.valueOf(2))
					);

			BigInteger employeesLeft = employees[i].mod(currCapacity);

			// Checks if there are still employees left on the floor
			if (employeesLeft.equals(BigInteger.ZERO)) {
				// If there are none, reset capacity
				currCapacity = capacity;
			} else {
				// If there are some left count seconds it takes to return to the floor and to take them to the underground
				seconds = seconds.add(
									BigInteger.valueOf(i + 1)
									.multiply(BigInteger.valueOf(2))
								);
				currCapacity = currCapacity.subtract(employeesLeft);
			}
		}

		return seconds;
	}
}
