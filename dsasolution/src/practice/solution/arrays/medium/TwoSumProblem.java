package practice.solution.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15, 3, 4, 5, 1, 6};
        int target = 7;

        int[] result = twoSum(array, target);

        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }

        result = twoSumOptimal(array, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }

        boolean isSumExists = greedyApproach(array, target);
        System.out.println("Sum exists: " + isSumExists);
    }

    // Brute force approach - O(n^2) time complexity
    private static int[] twoSum(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;

    }

    // HashMap approach - O(n) time complexity
    private static int[] twoSumOptimal(int[] array, int target) {

        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int remainingToTarget = target - array[i];
            if(numToIndexMap.containsKey(remainingToTarget)) {
                return new int[] {numToIndexMap.get(remainingToTarget), i};
            } else {
                numToIndexMap.put(array[i], i);
            }
        }

        return null;
    }

    // Greedy approach, optimal for yes and no scenario only
    private static boolean greedyApproach(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        boolean result = false;
        Arrays.sort(array);
        while (left < right) {
            if((array[left] + array[right]) == target) {
                result = true;
                break;
            } else if ((array[left] + array[right]) > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

}
