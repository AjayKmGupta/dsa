package practice.solution.patterns;

public class LeftInvertedTriangularNumberPattern {

	public static void main(String[] args) {
		int n = 8;
		printSquareStarPattern(n);
	}

	private static void printSquareStarPattern(int n) {

		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print( j + " ");
			}
			System.out.println();
		}
	}

}
