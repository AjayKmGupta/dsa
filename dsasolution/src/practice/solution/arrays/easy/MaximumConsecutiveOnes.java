package practice.solution.arrays.easy;

public class MaximumConsecutiveOnes {

	public static void main(String[] args) {

		int[] prices = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 };

		int len = findMaximumConsecutiveOnes(prices);

		System.out.println(len);

	}

	private static int findMaximumConsecutiveOnes(int[] prices) {

		int maxLen = 0;
		int counter = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] == 1) {
				counter++;
			} else {
				counter = 0;
			}
			maxLen = Math.max(maxLen, counter);
		}

		return maxLen;
	}

}
