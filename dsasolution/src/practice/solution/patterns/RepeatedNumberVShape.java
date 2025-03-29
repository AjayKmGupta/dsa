package practice.solution.patterns;

public class RepeatedNumberVShape {

	public static void main(String[] args) {
		int n = 4;
		printRepeatedNumberVShape(n);
	}

	private static void printRepeatedNumberVShape(int n) {

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < 2 * n; j++) {
				if (j <= i) {
					System.out.print((j + 1) + " ");
				} else if (j >= ((2 * n) - i - 1)) {
					System.out.print((2 * n - j) + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
