package com.interview;

import java.util.*;

public class MagicNumber {

    public static void main(String[] args) {
        final int MAGIC_NUMBER = 6174;
        final int MIN_VALUE = 1000;
        final int MAX_VALUE = 9999;

        final List<Integer> EXCEPTIONS = List.of(1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999);

        Map<Integer, Integer> iterationCounts = new HashMap<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            int currentNumber = i;
            int counter = 0;
            if (EXCEPTIONS.contains(currentNumber)) {
                iterationCounts.put(i, counter);
                continue;
            }
            while (currentNumber != MAGIC_NUMBER) {
                Integer[] digits = getDigits(currentNumber);
                sortDigits(digits, true);
                int minNumber = buildNumber(digits);
                sortDigits(digits, false);
                int maxNumber = buildNumber(digits);
                currentNumber = maxNumber - minNumber;
                counter++;
            }

            iterationCounts.put(i, counter);
        }

        for (Map.Entry<Integer, Integer> e : iterationCounts.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    private static Integer[] getDigits(int currentNumber) {
        Integer[] numArray = new Integer[4];
        int counter = 3;
        while (counter >= 0) {
            numArray[counter] = currentNumber % 10;
            currentNumber /= 10;
            counter--;
        }
        return numArray;
    }

    private static void sortDigits(Integer[] numArray, boolean isReverse) {
        if (isReverse) {
            Arrays.sort(numArray);
        } else {
            Arrays.sort(numArray, Collections.reverseOrder());
        }
    }

    private static int buildNumber(Integer[] digits) {
        int number = 0;
        for (int digit : digits) {
            number = 10 * number + digit;
        }
        return number;
    }
}
