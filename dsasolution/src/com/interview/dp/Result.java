package com.interview.dp;

import java.util.*;

class Result {
    private static Long[][][] memo;
    private static int[] digits;

    // Digit DP function to count numbers with a specific digit sum
    private static long countSum(int pos, int sum, int targetSum, boolean limited) {
        if (pos == digits.length) {
            return sum == targetSum ? 1 : 0;
        }
        if (memo[pos][sum][limited ? 1 : 0] != null) {
            return memo[pos][sum][limited ? 1 : 0];
        }

        int limit = limited ? digits[pos] : 9;
        long res = 0;
        for (int digit = 0; digit <= limit; digit++) {
            if (sum + digit <= targetSum) {
                res += countSum(pos + 1, sum + digit, targetSum, limited && digit == limit);
            }
        }
        memo[pos][sum][limited ? 1 : 0] = res;
        return res;
    }

    // Prepares digit array for given number
    private static void prepareDigits(long num) {
        String s = Long.toString(num);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
    }

    // Calculates count of numbers <= num with each digit sum
    private static long[] countDigitSums(long num) {
        if (num < 0) return new long[0];
        prepareDigits(num);

        int maxSum = 9 * digits.length;
        long[] counts = new long[maxSum + 1];

        for (int s = 0; s <= maxSum; s++) {
            memo = new Long[digits.length][maxSum + 1][2];
            counts[s] = countSum(0, 0, s, true);
        }
        return counts;
    }

    public static List<Long> waysToChooseSum(long lowLimit, long highLimit) {
        long[] countHigh = countDigitSums(highLimit);
        long[] countLow = countDigitSums(lowLimit - 1);

        int len = Math.max(countHigh.length, countLow.length);
        long maxCount = 0;
        long couponTypes = 0;

        for (int i = 0; i < len; i++) {
            long highVal = i < countHigh.length ? countHigh[i] : 0;
            long lowVal = i < countLow.length ? countLow[i] : 0;
            long diff = highVal - lowVal;

            if (diff > maxCount) {
                maxCount = diff;
                couponTypes = 1;
            } else if (diff == maxCount) {
                couponTypes++;
            }
        }
        return Arrays.asList(couponTypes, maxCount);
    }
}
