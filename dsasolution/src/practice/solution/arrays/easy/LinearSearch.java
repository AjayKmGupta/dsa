package practice.solution.arrays.easy;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LinearSearch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int target = 7;

		int index = linearSearch(arr, target);

		System.out.println("Element " + target + " found at index: " + index);
		
		Predicate<Integer> predicate = (x) -> x == 2020;
		predicate = predicate.and(x -> x < 0);
		System.out.println(predicate.test(2020));
		
		Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
		
		Comparator<LargestElement> comparator = (x, y) -> {
			Comparator.comparing(null);
			return index;
		};
		
		Object obj = new Object();
		
		List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).forEach(System.out::println);
	}

	private static int linearSearch(int[] arr, int target) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				index = i + 1; // +1 to convert to 1-based index;
				break;
			}
		}
		return index;
	}

}
