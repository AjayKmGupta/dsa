package practice.solution.patterns;

public class SquareStarPattern {
	
	public static void main(String[] args) {
		int n = 5;
		printSquareStarPattern(n);
	}

	private static void printSquareStarPattern(int n) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

}
