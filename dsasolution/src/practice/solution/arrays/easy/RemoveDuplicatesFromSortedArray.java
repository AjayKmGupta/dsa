package practice.solution.arrays.easy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 3, 4, 5, 5 };

		int length = removeDuplicates(arr);

		printSortedArray(arr, length);

	}

	private static int removeDuplicates(int[] arr) {

		int i = 0;

		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				arr[++i] = arr[j];
			}
		}

		return i + 1;
	}

	private static void printSortedArray(int[] arr, int length) {

		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
