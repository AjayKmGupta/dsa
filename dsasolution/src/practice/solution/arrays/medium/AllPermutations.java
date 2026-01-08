package practice.solution.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2};

        List<List<Integer>> result = new ArrayList<>();

        permutations(arr, 0, result);

        result.forEach( x -> {
            x.forEach( val -> System.out.print(val + " "));
            System.out.println();
        });
        
    }

    public static void permutations(int[] arr, int idx, List<List<Integer>> result) {

        if(idx == arr.length) {
            List<Integer> permutations = new ArrayList<>();
            Arrays.stream(arr).forEach(permutations::add);
            result.add(permutations);
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            //Swapping
            swap(arr, idx, i);
            //Recursive call
            permutations(arr, idx + 1, result);
            //Backtracking
            swap(arr, idx, i);
        }
    }

    private static void swap(int[] arr, int idx, int i) {
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }

}
