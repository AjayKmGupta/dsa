package practice.solution.arrays.easy;

public class SecondLargest {

	public static void main(String[] args) {

		int[] arr = { 3, 7, 8, 9, 1, 5 };

		int secondLargestElement = findSecondLargestElement(arr);

		System.out.println("Second Largest Element: " + secondLargestElement);
	}

	private static int findSecondLargestElement(int[] arr) {

		int largestElement = arr[0];
		int secondLargestElement = Integer.MIN_VALUE;

		for (int val : arr) {
			if (val > largestElement) {
				secondLargestElement = largestElement;
				largestElement = val;
			} else if (val > secondLargestElement && val < largestElement) {
				secondLargestElement = val;
			}
		}
		return secondLargestElement;
	}

}
