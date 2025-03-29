package practice.solution.patterns;

public class RightAngleTriangleAlphabet {

	public static void main(String[] args) {
		int n = 5;
		printRightAngleTriangleAlphabet(n);
	}

	private static void printRightAngleTriangleAlphabet(int n) {

		for (int i = 0; i < n; i++) {
			for (char ch = 'A'; ch <= 'A' + i; ch++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}

	}
}
