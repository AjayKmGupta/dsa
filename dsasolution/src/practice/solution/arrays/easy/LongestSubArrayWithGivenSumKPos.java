package practice.solution.arrays.easy;

public class LongestSubArrayWithGivenSumKPos {

	public static void main(String[] args) {

//		int[] array = { 2, 3, 5 };
		int[] array = { -1, 1, 1 };
		
		int k = 1;

		int len = findLongestSubArrayWithSumKLength(array, k);

		System.out.println(len);

	}

	private static int findLongestSubArrayWithSumKLength(int[] array, int k) {

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

}
