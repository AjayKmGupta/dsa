package practice.solution.patterns;

public class StraightInvertedRightAngleTriangle {

	public static void main(String[] args) {

		int n = 5;
		printStraightInvertedRightAngleTriangle(n);
	}

	private static void printStraightInvertedRightAngleTriangle(int n) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
		}
	}
	
}
