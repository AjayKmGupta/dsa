package practice.solution.patterns;

public class SpiralNumberPattern {

	public static void main(String[] args) {

		int n = 3;

		printSpiralNumberPattern(n);
	}

	private static void printSpiralNumberPattern(int n) {

		int top = 0;
		int left = 0;
		int right = 0;
		int bottom = 0;

		for (int i = 0; i < 2 * n - 1; i++) {

			for (int j = 0; j < 2 * n - 1; j++) {
				left = j;
				right = 2 * n - j - 2;
				top = i;
				bottom = 2 * n - i - 2;

				int min = Math.min(Math.min(top, bottom), Math.min(left, right));

				System.out.print(n - min);
			}
			System.out.println();
		}
	}
}
