package practice.solution.patterns;

public class StraightInvertedPascalTriangle {

	public static void main(String[] args) {
		int n = 5;
		printPascalTriangle(n);
	}

	private static void printPascalTriangle(int n) {

		for(int i = 0; i < n; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			
			for (int k = 0; k < ((2 * i) +1); k++) {
				System.out.print( "*");
			}
			System.out.println();
		}
		
		for (int i = n; i > 0; i--) {

			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k < ((2 * i) - 1); k++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}
}
