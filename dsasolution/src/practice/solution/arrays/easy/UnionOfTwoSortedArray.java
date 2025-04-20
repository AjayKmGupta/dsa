package practice.solution.arrays.easy;

import java.util.Arrays;

public class UnionOfTwoSortedArray {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 3, 4, 5, 6, 7 };
		
		int[] union = unionOfSortedArrays(arr1, arr2);
		
		printArray(union);
		
	}

	private static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {
		int[] union = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				union[k++] = arr1[i++];
			} else if (arr1[i] > arr2[j]) {
				union[k++] = arr2[j++];
			} else {
				union[k++] = arr1[i++];
				j++;
			}
		}
		while (i < arr1.length) {
			union[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			union[k++] = arr2[j++];
		}
		return union;
	}

	private static void printArray(int[] union) {

		Arrays.stream(union).forEach(val -> System.out.print(val + " "));
		
	}

}
