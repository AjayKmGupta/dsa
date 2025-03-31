package practice.solution.sorting;

import java.util.Arrays;

public class QuickSort {

	// Time Complexity: O(n log n)
	// Space complexity : O(1), there will be stack space but we ignore that here
	public static void main(String[] args) {

		int[] arr = { 10, 7, 8, 9, 1, 5 };
		
		quickSort(arr, 0, arr.length - 1);
		
		printArray(arr);
		
	}

	private static void quickSort(int[] arr, int start, int end) {

		if (start > end) {
			return;
		}

		int partitionIndex = partition(arr, start, end);

		quickSort(arr, start, partitionIndex - 1);

		quickSort(arr, partitionIndex + 1, end);

	}

	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[start];
		
		int i = start;
		int j = end;
		
		while (i < j) {

			while (i <= end - 1 && arr[i] <= pivot) {
				i++;
			}

			while (j >= start && arr[j] > pivot) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}

		}
		swap(arr, start, j);
        return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		
		Arrays.stream(arr).forEach( val -> System.out.print(val + " "));
		
	}
	
}
