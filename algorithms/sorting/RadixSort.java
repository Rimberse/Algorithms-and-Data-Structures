package sorting;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class RadixSort {
	private static StringBuilder sb;

	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("sorting_input_e.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();
		sb = new StringBuilder();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int n = scanner.nextInt();
		BigInteger[] array = new BigInteger[n];
		int maxNbDigits = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			String input = scanner.next();
			maxNbDigits = Math.max(input.length(), maxNbDigits);
			array[i] = new BigInteger(input);
		}

		sb.append("Initial array:\n");
		printArrayWithLeadingZerosDelimitedByComma(array, maxNbDigits);
		sb.append("\n");

		radixSort(array, maxNbDigits);

		sb.append("Sorted array:\n");
		printArrayWithLeadingZerosDelimitedByComma(array, maxNbDigits);
		sb.append("\n");

		writer.write(sb.toString());
		scanner.close();
		writer.close();
	}

	public static BigInteger max(BigInteger[] array) {
		BigInteger max = BigInteger.ZERO;

		for (BigInteger item : array)
			max = max.max(item);

		return max;
	}

	public static int nbDigits(BigInteger number) {
		int count = 0;

		do {
			number = number.divide(BigInteger.TEN);
			count++;
		} while (!number.equals(BigInteger.ZERO));

		return count;
	}

	public static String formatWithLeadingZeros(BigInteger number, int width) {
		return String.format("%0" + width + "d", number);
	}

	public static int nthDigit(BigInteger number, int digit) {
		return number.divide(BigInteger.TEN.pow(digit - 1)).mod(BigInteger.TEN).intValue();
	}

	public static void printArrayWithLeadingZerosDelimitedByComma(BigInteger[] array, int maxNbDigits) {
		for (int i = 0; i < array.length; i++) {
			sb.append(i > 0 ? ", " : "");

			for (int j = 0; j < maxNbDigits - nbDigits(array[i]); j++)
				sb.append("0");

			sb.append(array[i]);
		}
	}

	public static void printListWithLeadingZerosDelimitedByComma(List<BigInteger> list, int maxNbDigits) {
		for (int j = 0; j < list.size(); j++) {
			sb.append(j > 0 ? ", " : "");

			for (int k = 0; k < maxNbDigits - nbDigits(list.get(j)); k++)
				sb.append("0");

			sb.append(list.get(j));
		}
	}

	public static void countingSort(BigInteger[] array, int digit, int maxNbDigits) {
		sb.append("**********\n");
		sb.append("Phase ");
		sb.append(digit);
		sb.append("\n");

		int[] count = new int[10];
		@SuppressWarnings("unchecked")
		List<BigInteger>[] buckets = new ArrayList[10];

		for (int i = 0; i < 10; i++) {
			buckets[i] = new ArrayList<>();
		}

		for (int i = 0; i < array.length; i++) {
			int value = nthDigit(array[i], digit);
			count[value]++;
			buckets[value].add(array[i]);
		}

		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];

		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++)
				array[index++] = buckets[i].get(j);
		}

		for (int i = 0; i < count.length; i++) {
			sb.append("Bucket ");
			sb.append(i);
			sb.append(": ");

			if (buckets[i].isEmpty())
				sb.append("empty");
			else {
				List<BigInteger> numbers = buckets[i];
				printListWithLeadingZerosDelimitedByComma(numbers, maxNbDigits);
			}

			sb.append("\n");
		}
	}

	public static void radixSort(BigInteger[] array, int maxNbDigits) {
		for (int i = 1; i <= maxNbDigits; i++) {
			countingSort(array, i, maxNbDigits);
		}

		sb.append("**********\n");
	}
}
