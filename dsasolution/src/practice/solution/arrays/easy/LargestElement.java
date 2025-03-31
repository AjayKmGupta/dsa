package practice.solution.arrays.easy;

public class LargestElement {

	public static void main(String[] args) {

		int[] arr = { 3, 7, 8, 9, 1, 5 };

		int largestElement = findLargestElement(arr);

		System.out.println("Largest Element: " + largestElement);
	}

	private static int findLargestElement(int[] arr) {

		int largestElement = arr[0];

		for (int val : arr) {
			if (val > largestElement) {
				largestElement = val;
			}
		}

		return largestElement;
	}

}
