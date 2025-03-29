package practice.solution.patterns;

public class SpiralNumberPatternWithArray {

	public static void main(String[] args) {

		int n = 5;

		int[][] patternArray = printSpiralNumberPattern(n);

		printPattern(patternArray);

	}

	private static int[][] printSpiralNumberPattern(int n) {

		int num = n;
		int maxRow = 0;
		int maxCol = 0;

		int[][] patternArray = new int[2 * n - 1][2 * n - 1];

		for (int i = 0; i < 2 * n - 1; i++) {
			
			for (int j = i; j < 2 * n - i - 1; j++) {
				patternArray[i][j] = num;
				maxCol = j;
			}

			for (int j = i + 1; j < 2 * n - i - 1; j++) {
				patternArray[j][maxCol] = num;
				maxRow = j;
			}

			for (int j = 2 * n - i - 2; j > i; j--) {
				patternArray[maxRow][j] = num;
			}

			for (int j = 2 * n - i - 2; j > i; j--) {
				patternArray[j][i] = num;
			}
			num--;

		}

		return patternArray;

	}

	private static void printPattern(int[][] patternArray) {

		for (int i = 0; i < patternArray.length; i++) {
			for (int j = 0; j < patternArray[i].length; j++) {
				System.out.print(patternArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
