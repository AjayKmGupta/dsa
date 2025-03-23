/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] dataArray = new int[]{2, 5, 7, 9, 14, 23, 35, 48, 56, 67};
        int key = 22;
        int index = BinarySearch.findKeyInGivenArray(dataArray, key);
        if (index > 0) {
            System.out.println("At index: " + index);
        } else {
            System.out.println("The given value doesn't exist");
        }
    }

    private static int findKeyInGivenArray(int[] dataArray, int key) {
        int index = Integer.MIN_VALUE;
        int first = 0;
        int last = dataArray.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (key == dataArray[mid]) {
                index = mid;
                break;
            }
            if (key < dataArray[mid]) {
                last = mid - 1;
                continue;
            }
            first = mid + 1;
        }
        return index;
    }
}
