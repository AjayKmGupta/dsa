package practice.solution.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MaorityElements {

    public static void main(String[] args) {

        int[] arr = {2, 2, 3, 3, 1, 2, 2};

        // n2 time complexity
        int count = bruteForceApproach(arr);

        System.out.println(count);

        // Using map time complexity (N log N + log N)
        count = solveUsingMap(arr);
        System.out.println(count);

        // optimalSolution time complexity O(n) + O(n) if not stated majority exists for sure, SC(1)
        count = mooreMajorityAlgo(arr);

    }

    private static int mooreMajorityAlgo(int[] arr) {

        int count = 0;
        int element = 0;

        for(int i = 0; i < arr.length; i++) {
            if(count == 0) {
                count = 1;
                element = arr[i];
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        // This is not required if stated that there exists always a majority element
        for (int val: arr) {
            if (element == val) {
                count++;
            }
        }
        if (count <= arr.length/2) {
            element = -1;
        }
        return element;
    }

    private static int solveUsingMap(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int element = -1;
        for (int val: arr) {
            if(countMap.containsKey(val)) {
                countMap.put(val, countMap.get(val) + 1);
            } else {
                countMap.put(val, 1);
            }
            // The above logic can be replaced by
            // countMap.merge(val, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if(entry.getValue() > arr.length/2) {
                element = entry.getKey();
                break;
            }
        }

        return element;
    }

    private static int bruteForceApproach(int[] arr) {

        for (int i = 0; i < ((arr.length / 2) + 1); i++) {
            int count = 0;
            for(int j = i; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > arr.length/2) {
                return arr[i];
            }
        }
        return -1;
    }

}
