package practice.solution.arrays.easy;

import java.util.Arrays;

public class IntersectionOfTwoSortedArray {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 3, 4, 5, 6, 7 };

		int[] intersection = intersectionOfSortedArrays(arr1, arr2);

		printArray(intersection);
	}

	private static int[] intersectionOfSortedArrays(int[] arr1, int[] arr2) {

		int i = 0, j = 0, k = 0;
		int[] intersection = new int[Math.min(arr1.length, arr2.length)];
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] == arr2[j]) {
				intersection[k++] = arr1[i++];
				j++;
			} else {
				i++;
			}

		}

		return intersection;
	}

	private static void printArray(int[] union) {

		Arrays.stream(union).forEach(val -> System.out.print(val + " "));

	}
}
