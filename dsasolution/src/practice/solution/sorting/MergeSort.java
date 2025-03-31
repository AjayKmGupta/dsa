package practice.solution.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	// Time Complexity of worst, average and best case: O(n log2 n)
	// Space Complexity: O(n)
	public static void main(String[] args) {

		int[] arr = { 12, 11, 13, 5, 6, 7 };
//		int[] arr = { 9, 4, 7, 6, 3, 1, 5 };
		mergeSort(arr, 0, arr.length - 1);

		printArray(arr);

	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		List<Integer> temp = new ArrayList<>(); // temporary array
		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		while (right <= end) {
			temp.add(arr[right]);
			right++;
		}

		for (int i = start; i <= end; i++) {
			arr[i] = temp.get(i - start);
		}

	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
	}

}
