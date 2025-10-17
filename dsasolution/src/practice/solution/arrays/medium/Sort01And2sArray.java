package practice.solution.arrays.medium;

import java.util.Arrays;

public class Sort01And2sArray {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 0, 1, 2, 1, 1, 0, 0, 0, 1, 1, 1, 1, 2, 2};

        optimalSolution(arr);

        dutchNationalFlagAlgorithm(arr);

        Arrays.stream(arr).forEach(System.out::print);

    }

    private static void dutchNationalFlagAlgorithm(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid < high) {

            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

    }

    private static void optimalSolution(int[] arr) {

        int zeroCount = 0;
        int onesCount = 0;
        int twosCount = 0;

        for (int i : arr) {
            if (i == 0) {
                zeroCount++;
            } else if (i == 1) {
                onesCount++;
            } else {
                twosCount++;
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }

        for (int i = zeroCount; i < zeroCount + onesCount; i++) {
            arr[i] = 1;
        }

        for (int i = zeroCount + onesCount; i < zeroCount + onesCount + twosCount; i++) {
            arr[i] = 2;
        }
    }

}
