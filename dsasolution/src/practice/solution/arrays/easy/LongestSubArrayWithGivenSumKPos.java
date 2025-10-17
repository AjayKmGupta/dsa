package practice.solution.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSumKPos {

	public static void main(String[] args) {

//		int[] array = { 2, 3, 5 };
		int[] array = { -1, 1, 1 };
		
		int k = 2;

		int len = findLongestSubArrayWithSumK(array, k);

		System.out.println(len);

		len = findLongestSubArrayWithSumKOptimal(array, k);

		System.out.println(len);

		// This will not work for negative numbers
		// It works only for positive numbers
		// For negative numbers findLongestSubArrayWithSumKLengthOptimal will work
		len = findLongestSubArrayWithSumKWithTwoPointers(array, k);

		System.out.println(len);

	}

	private static int findLongestSubArrayWithSumK(int[] array, int k) {

		int maxLen = 0;
		
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum = sum + array[j];
				if (sum == k) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}

		return maxLen;
	}

	private static int findLongestSubArrayWithSumKOptimal(int[] array, int k) {
		Map<Long, Integer> preSumMap = new HashMap<>();
		long sum = 0;
		int maxLen = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == k) {
				maxLen = Math.max(maxLen, i + 1);
			}
			long rem = sum - k;
			if (preSumMap.containsKey(rem)) {
				int len = i - preSumMap.get(rem);
				maxLen = Math.max(maxLen, len);
			}
			if (!preSumMap.containsKey(sum)) {
				preSumMap.put(sum, i);
			}
		}

		return maxLen;
	}

	private static int findLongestSubArrayWithSumKWithTwoPointers(int[] array, int k) {
		int left = 0, right = 0;
		int sum = 0;
		int maxLen = 0;
		while (right < array.length) {
			sum += array[right];
			while (sum > k && left <= right) {
				sum -= array[left];
				left++;
			}
			if (sum == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}
			right++;
		}

		return maxLen;
	}
}
