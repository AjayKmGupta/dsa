package practice.solution.arrays.easy;

public class FindMissingNumber {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 1, 6, 8, 7 };

		int n = 8;

		int missingNum = findMissingNumber(arr, n);

		System.out.println(missingNum);

	}

	private static int findMissingNumber(int[] arr, int n) {
		int missingNum;
		//missingNum = methodA(arr, n);
		//missingNum = methodB(arr, n);
		missingNum = methodC(arr, n);
		return missingNum;
	}

	private static int methodC(int[] arr, int n) {
		
		int actXor = 0;
		int expXor = 0;
		
		for (int i = 1; i < n; i++) {
			actXor = actXor ^ arr[i - 1];
			expXor = expXor ^ i;
		}
		expXor = expXor ^ n;
		
		return actXor ^ expXor;
	}

	private static int methodB(int[] arr, int n) {

		int expectedSum = n * (n + 1) >>> 1;
		int actualSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			actualSum += arr[i];
		}
		return expectedSum - actualSum;
	}

	private static int methodA(int[] arr, int n) {
		int expectedSum = 0;
		int actualSum = 0;
		for (int i = 1; i < n; i++) {
			expectedSum += i;
			actualSum += arr[i - 1];
		}
		expectedSum += n;
		return expectedSum - actualSum;
	}

}
