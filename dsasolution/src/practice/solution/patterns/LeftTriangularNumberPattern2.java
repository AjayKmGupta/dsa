package practice.solution.patterns;

public class LeftTriangularNumberPattern2 {

	public static void main(String[] args) {
		int n = 8;
		printSquareStarPattern(n);
	}

	private static void printSquareStarPattern(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print( (i + 1) + " ");
			}
			System.out.println();
		}
	}

}
