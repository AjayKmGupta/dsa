package practice.solution.arrays.easy;

import java.util.Arrays;

public class LeftRotateBy1 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		
		int k = 1;
		
		leftRotate(arr, k);
		
		printArray(arr);
		
	}
	
	
	private static void leftRotate(int[] arr, int k) {
		
		int temp = arr[0];		
		for (int i = 0; i < arr.length; i++) {
			arr[i % arr.length] = arr[(i + k) % arr.length];		
		}
		arr[arr.length - 1] = temp;
	}

	private static void printArray(int[] arr) {

		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		
	}

}
