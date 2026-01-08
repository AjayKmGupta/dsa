package practice.solution.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrangeElementsBySign {

    public static void main(String[] args) {

        // There are equal positive and negative numbers
        int[] arr = {3, 1, -2, -5, 2, -4};

        // Rearrange means first +ve and then -ve
        //reArrangeUsingBruteForce(arr);

        arr = reArrangeUsingOptimal(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        // Solve the another variety where it is not equal, left numbers should be added at end
        int[] unequalArr = {3, -3, -2, -5, -6, -4, 1, 2};
        reArrangeArray(unequalArr);

        Arrays.stream(unequalArr).forEach(i -> System.out.print(i + " "));


    }

    private static void reArrangeArray(int[] arr) {

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positives.add(arr[i]);
            } else {
                negatives.add(arr[i]);
            }
        }
        int minLen = Math.min(positives.size(), negatives.size());
        int positiveIdx = 0;
        int negativeIdx = 0;
        for (int i = 0; i < minLen; i++) {
            arr[2 * i] = positives.get(positiveIdx++);
            arr[2 * i + 1] = negatives.get(negativeIdx++);
        }
        int maxLen = Math.max(positives.size(), negatives.size());
        if(positives.size() == maxLen) {
            for (int i = minLen; i < maxLen; i++) {
                arr[i] = positives.get(positiveIdx++);
            }
        } else {
            for (int i = 2 * minLen; i < minLen + maxLen; i++) {
                arr[i] = negatives.get(negativeIdx++);
            }
        }
    }

    // Time complexity O(n) and space O(n)
    private static int[] reArrangeUsingOptimal(int[] arr) {
        int[] ans = new int[arr.length];
        int positiveIdx = 0;
        int negativeIdx = 1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                ans[positiveIdx] = arr[i];
                positiveIdx += 2;
            } else {
                ans[negativeIdx] = arr[i];
                negativeIdx += 2;
            }
        }
        return ans;
    }

    // Time complexity O(n) + O(n/2) and space O(n)
    private static void reArrangeUsingBruteForce(int[] arr) {
        int[] positiveArray = new int[arr.length/2];
        int[] negativeArray = new int[arr.length/2];
        int positiveArrayIndex = 0;
        int negativeArrayIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                positiveArray[positiveArrayIndex++] = arr[i];
            } else {
                negativeArray[negativeArrayIndex++] = arr[i];
            }
        }
        // 0, 2, 4, 6, 8
        for (int i = 0; i < positiveArray.length; i++) {
            arr[2 * i] = positiveArray[i];
            arr[2 * i + 1] = negativeArray[i];
        }
    }

}
