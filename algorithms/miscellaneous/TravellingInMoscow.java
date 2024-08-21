package miscellaneous;

import java.io.File;
import java.io.IOException;

import utilities.OptimizedScanner;
import utilities.OptimizedWriter;

public class TravellingInMoscow {
	public static void main(String[] args) {
//		OptimizedScanner scanner = new OptimizedScanner();
		File file = new File("misc_input_c.txt");
		OptimizedScanner scanner = null;
		OptimizedWriter writer = new OptimizedWriter();

		try {
			scanner = new OptimizedScanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		int xA = scanner.nextInt();
        int yA = scanner.nextInt();
        int xB = scanner.nextInt();
        int yB = scanner.nextInt();

        double minDistance;
        
        if (xA == 0 && yA == 0) {
            minDistance = Math.hypot(xB, yB);
        } else if (xB == 0 && yB == 0) {
            minDistance = Math.hypot(xA, yA);
        } else {
            minDistance = calculateDistance(xA, yA, xB, yB);
        }

        writer.writeln(String.format("%.12f", minDistance));
        scanner.close();
        writer.close();
    }

    private static double calculateDistance(int xA, int yA, int xB, int yB) {
        double distanceA = Math.hypot(xA, yA);
        double distanceB = Math.hypot(xB, yB);
        double angleA = Math.atan2(yA, xA);
        double angleB = Math.atan2(yB, xB);

        double angleDifference = angleB - angleA;
        
        if (angleDifference < -Math.PI) {
        	angleDifference += 2 * Math.PI;
        } else if (angleDifference > Math.PI) {
        	angleDifference -= 2 * Math.PI;
        }

        double minDistance;
        
        if (angleDifference == 0) {
            minDistance = Math.hypot(xB - xA, yB - yA);
        } else {
            double radius = Math.min(distanceA, distanceB);
            double arcLength = Math.abs(angleDifference) * radius;
            double radiusDifference = Math.abs(distanceA - distanceB);
            minDistance = Math.min(distanceA + distanceB, arcLength + radiusDifference);
        }

        return minDistance;
    }
}
