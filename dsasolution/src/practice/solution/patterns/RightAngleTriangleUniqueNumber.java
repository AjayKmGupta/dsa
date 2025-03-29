package practice.solution.patterns;

public class RightAngleTriangleUniqueNumber {

	public static void main(String[] args) {
		int n = 5;
		printRightAngleTriangleUniqueNumber(n);
	}

	private static void printRightAngleTriangleUniqueNumber(int n) {
		
		int k = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<=i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
		}
		
	}
}
