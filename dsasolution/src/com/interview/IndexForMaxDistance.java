package com.interview;



public class IndexForMaxDistance {


    public static void main(String[] args) {

        // 1 0 1 0 0 0 0 0 1

        int[] arr = {1, 0, 1, 0, 0, 0, 0, 0, 1};

        // [1, 2, 2, 4, 5]
        // [ 10, 20, 20, 40, 50]
        // [11, 22, 20, 41, 51] (A*Num + B)

        int resultIndex = -1;
        int maxDistance = 0;
        int counter = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == 0) {
                counter++;
            } else {
                if(counter > maxDistance) {
                    maxDistance = counter;
                    resultIndex = i - maxDistance;
                }
                counter = 0;
            }

        }

        System.out.println("The index is: " + resultIndex);

    }

}
