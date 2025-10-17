package practice.solution.arrays.medium;

public class MaxSubArraySum {

    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        // Kadane's algo, time complexity O(n) & SC - O(1)
        long maxSum = findMaxSubArraySum(arr);

        System.out.println(maxSum);

        findMaxSubArray(arr);
    }

    private static void findMaxSubArray(int[] arr) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int subArraStart = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) {
                subArraStart = i;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansStart = subArraStart;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
                ansStart = -1;
                ansEnd = -1;
            }
        }
        // This is for empty sum, if none matches
        if (max < 0) {
            max = 0;
        }

        if (ansStart >= 0 && ansEnd > 0 && max != 0) {
            for (int i = ansStart; i <= ansEnd; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static long findMaxSubArraySum(int[] arr) {

        long sum = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        // This is for empty sum, if none matches
        if (max < 0) {
            max = 0;
        }
        return max;
    }

}
