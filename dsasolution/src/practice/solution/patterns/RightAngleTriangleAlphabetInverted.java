package practice.solution.patterns;

public class RightAngleTriangleAlphabetInverted {

	public static void main(String[] args) {
		int n = 5;
		printRightAngleTriangleAlphabet(n);
	}

	private static void printRightAngleTriangleAlphabet(int n) {

		for (int i = n; i > 0; i--) {
			for (char ch = 'A'; ch < 'A' + i; ch++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}

	}
}
