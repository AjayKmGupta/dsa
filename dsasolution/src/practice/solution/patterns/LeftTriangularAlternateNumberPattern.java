package practice.solution.patterns;

public class LeftTriangularAlternateNumberPattern {

	public static void main(String[] args) {
		int n = 5;
		printSquareStarPattern(n);
	}

	private static void printSquareStarPattern(int n) {

		int value = 1;
		for (int i = 0; i < n; i++) {
			value = i % 2 == 0 ? 1 : 0;
			for (int j = 0; j <= i; j++) {
				System.out.print(value + " ");
				value = 1 - value;
			}
			System.out.println();
		}
	}

}
