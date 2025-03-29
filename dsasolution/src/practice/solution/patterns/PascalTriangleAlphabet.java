package practice.solution.patterns;

public class PascalTriangleAlphabet {

	public static void main(String[] args) {
		int n = 4;
		printPascalTriangle(n);
	}

	private static void printPascalTriangle(int n) {
		
		for(int i = 0; i < n; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}

			int alphabet = 65;
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j));
			}
			for (int j = i; j > 0; j--) {
				System.out.print((char) (alphabet + j - 1));
			}

			System.out.println();
		}
		
	}
	
}
