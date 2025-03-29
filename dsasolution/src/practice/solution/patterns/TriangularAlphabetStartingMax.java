package practice.solution.patterns;

public class TriangularAlphabetStartingMax {

	public static void main(String[] args) {
		int n = 3;
		printRightAngleTriangleAlphabet(n);
	}

	private static void printRightAngleTriangleAlphabet(int n) {

		for (int i = 0; i < n; i++) {
			for (char ch = (char) ('A' + n - 1); ch >= (char) ('A' + n - i - 1); ch--) {
				System.out.print(((char) (ch)) + " ");
			}
			System.out.println();
		}

	}
}
