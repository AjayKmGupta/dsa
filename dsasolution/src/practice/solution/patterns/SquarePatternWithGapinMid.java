package practice.solution.patterns;

public class SquarePatternWithGapinMid {

	public static void main(String[] args) {

		int n = 3;
		printSquarePatternWithGapinMid(n);

	}

	private static void printSquarePatternWithGapinMid(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n; j++) {
				if ((j >= n - i && j < n) || (j >= n && j < n + i)) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n; j++) {
				if ((j <= i) || (j >= 2*n-i-1)) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
