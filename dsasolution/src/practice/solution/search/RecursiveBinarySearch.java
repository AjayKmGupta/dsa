/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.search;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] dataArray = new int[]{2, 5, 7, 9, 14, 23, 35, 48, 56, 67};
        int key = 23;
        int start = 0;
        int end = dataArray.length;
        int index = RecursiveBinarySearch.findKeyInGivenArrayRecursively(dataArray, key, start, end);
        if (index > 0) {
            System.out.println("At index: " + index);
        } else {
            System.out.println("The given value doesn't exist");
        }
    }

    private static int findKeyInGivenArrayRecursively(int[] dataArray, int key, int start, int end) {
        int mid = (start + end) / 2;
        if (start <= end) {
            if (key == dataArray[mid]) {
                return mid;
            }
            if (key > dataArray[mid]) {
                return RecursiveBinarySearch.findKeyInGivenArrayRecursively(dataArray, key, mid + 1, end);
            }
            return RecursiveBinarySearch.findKeyInGivenArrayRecursively(dataArray, key, start, mid - 1);
        }
        return -1;
    }
}
