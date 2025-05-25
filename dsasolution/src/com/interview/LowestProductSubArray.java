package com.interview;

import java.util.Arrays;

public class LowestProductSubArray {

	public static void main(String[] args) {

		// -1,0,1,-2,5,-7,9, minimum length = 2 with minimum product

		// Rule if negative number, consider only odd number of occurrences
		// If any number as negative number, we should consider highest, then lowest and
		// then lower
		// If any zero and no negative, then include zero
		// If only positives, then consider minimum numbers

		int product = Integer.MIN_VALUE;

		int[] arr = { -1, 0, 1, -2, 5, -7, 9 };

		boolean isAnyNegative = isAnyNegativeNumberPresent(arr);

		if (isAnyNegative) {
			product = getMinMultiplicationForNeg(arr);
		} else if (anyZeroNumberPresent(arr)) {
			product = getMinMultiplicationForZero(arr);
		} else {
			product = getMinMultiplicationForPositive(arr);
		}
		System.out.println("Multiplication: " + product);
	}

	private static int getMinMultiplicationForPositive(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int i : arr) {
			if (i > max) {
				secondMax = max;
				max = i;
			} else if (i > secondMax && i != max) {
				secondMax = i;
			}
		}

		return max * secondMax;
	}

	private static int getMinMultiplicationForZero(int[] arr) {
		return 0;
	}

	private static int getMinMultiplicationForNeg(int[] arr) {

		int countNegative = 0;
		int multiplication = 1;
		int minNegative = 1;
		for (int i : arr) {
			if (i != 0) {
				multiplication *= i;
			}
			if (i < 0) {
				countNegative++;
				if (i < minNegative) {
					minNegative = i;
				}
			}
		}
		if (countNegative % 2 == 0) {
			multiplication /= -minNegative;
		}

		return multiplication;
	}

	private static boolean anyZeroNumberPresent(int[] arr) {
		return Arrays.stream(arr).anyMatch(i -> i == 0);
	}

	private static boolean isAnyNegativeNumberPresent(int[] arr) {

		return Arrays.stream(arr).anyMatch(i -> i < 0);
	}

}
