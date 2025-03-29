package practice.solution.patterns;

public class SquareGapInBetweenPattern {

	public static void main(String[] args) {

		int n = 5;
		printSquareGapInBetweenPattern(n);

	}

	private static void printSquareGapInBetweenPattern(int n) {

		int N = n % 2 == 0 ? n/2 : n/2+1;
		int k = n % 2 == 0 ? 0 : 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < n; j++) {
				if (j < N - i || j >= N + i - k) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		int i = n % 2 == 0 ? 0 : 1;
		// TODO Auto-generated method stub
		for ( ;i < N; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= i || j >= n - i - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
