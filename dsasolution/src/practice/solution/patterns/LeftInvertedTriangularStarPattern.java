package practice.solution.patterns;

public class LeftInvertedTriangularStarPattern {

	public static void main(String[] args) {
		int n = 8;
		printSquareStarPattern(n);
	}

	private static void printSquareStarPattern(int n) {

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
