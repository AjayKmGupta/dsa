package practice.solution.patterns;

public class RightAngleTriangleRepeatedAlphabet {

	public static void main(String[] args) {
		int n = 5;
		printRightAngleTriangleAlphabet(n);
	}

	private static void printRightAngleTriangleAlphabet(int n) {
		for (char ch = 'A'; ch < 'A' + n; ch++) {
			for (char i = 'A'; i <= ch; i++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}

	}
}
