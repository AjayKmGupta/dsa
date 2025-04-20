package practice.solution.arrays.easy;

import java.util.Arrays;

public class LeftRotateByK {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int k = 3;

		k = k % arr.length;

		printArray(arr);
		
		reverse(arr, 0, k - 1);

		reverse(arr, k, arr.length - 1);

		reverse(arr, 0, arr.length - 1);
		printArray(arr);

	}

	private static void reverse(int[] arr, int start, int end) {

		while(start <= end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}

	private static void printArray(int[] arr) {

		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();

	}

}
