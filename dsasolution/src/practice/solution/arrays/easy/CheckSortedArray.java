package practice.solution.arrays.easy;

public class CheckSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		boolean isSorted = checkSortedArray(arr);

		System.out.println("Is Sorted: " + isSorted);
	}

	private static boolean checkSortedArray(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}

		return true;
	}
}
