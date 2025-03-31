package practice.solution.sorting;

import java.util.Arrays;

public class InsertionSort {

	// Worst and average case time Complexity: O(n^2) and best case is O(n
	public static void main(String[] args) {

		int[] arr = new int[] { 34, 10, 2, 56, 7, 67, 88, 42 };
		
		insertionSort(arr);
		System.out.println("After Sorting");
		printArray(arr);
		
	}

	private static void insertionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int j = i;

			while (j > 0 && arr[j - 1] > arr[j]) {
				swap(arr, j, j - 1);
				j--;
			}
			printArray(arr);
		}

	}

	private static void swap(int[] arr, int j, int i) {

		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
	}

}
