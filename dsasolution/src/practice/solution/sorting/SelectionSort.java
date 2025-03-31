package practice.solution.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	// Best, average and worst case time complexity is O(n^2)

	public static void main(String[] args) {

		int[] arr = { 64, 25, 12, 22, 11, 33, 45, 67, 89, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		selectionSort(arr);
		System.out.println("Sorted array");
		printArray(arr);
	}

	private static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
			printArray(arr);
		}

	}

	private static void swap(int[] arr, int i, int minIndex) {

		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;

	}

	private static void printArray(int[] arr) {

		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
	}

}
