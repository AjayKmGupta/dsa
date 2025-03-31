package practice.solution.sorting;

import java.util.Arrays;

public class BubbleSort {

	// Best case time complexity is O(n) and worst and average case time complexity is O(n^2)
	public static void main(String[] args) {

		int[] arr = { 8, 9, 1, 4, 3, 34, 5, 65, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 };

		bubbleSort(arr);
		System.out.println("After sorting: ");
		printArray(arr);
	}

	private static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			printArray(arr);
		}

	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
	}
}
