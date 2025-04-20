package practice.solution.arrays.easy;

import java.util.Arrays;

public class MoveAllZerosAtEnd {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 3, 12, 8, 0, 0, 5, 0 };

		moveAllZerosAtEnd(arr);

		printArray(arr);

	}

	private static void moveAllZerosAtEnd(int[] arr) {

		int zerosCount = 0;
		for (int i = 0, j = 0; i < arr.length; i++) {
			while (i < arr.length && arr[i] == 0) {
				i++;
				zerosCount++;
			}
			if (i < arr.length) {
				arr[j++] = arr[i];
			}
		}
		for (int i = arr.length - zerosCount; i < arr.length; i++) {
			arr[i] = 0;
		}

	}

	private static void printArray(int[] arr) {

		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
	}

}
