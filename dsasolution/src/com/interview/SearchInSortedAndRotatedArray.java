package com.interview;

public class SearchInSortedAndRotatedArray {

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};

        int key = 10;

        int index = solutionInInterview(arr, key);

        System.out.println(index);

        index = anotherSolution(arr, key);

        System.out.println(index);
    }

    private static int solutionInInterview(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        int index = -1;
        while (mid >= left && mid <= right) {
            if(arr[mid] == key) {
                index = mid;
                break;
            } else if (key < arr[mid] && key >= arr[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        return index;
    }

    private static int anotherSolution(int[] arr, int key) {

        int index = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = ( left + right ) / 2;
            if(key == arr[mid]) {
                index = mid;
                break;
            }

            //If left half sorted
            if(arr[mid] > arr[left]) {
                if(key < arr[mid] && key >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right half will be sorted
                if(key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return index;
    }

}
