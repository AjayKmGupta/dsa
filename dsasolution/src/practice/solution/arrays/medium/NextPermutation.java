package practice.solution.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2};
        nextPermutationBruteFrce(arr);

    }

    private static void nextPermutationBruteFrce(int[] arr) {

        AllPermutations allPermutations = new AllPermutations();
        List<List<Integer>> result = new ArrayList<>();

        allPermutations.permutations(arr, 0, result);

    }

}
