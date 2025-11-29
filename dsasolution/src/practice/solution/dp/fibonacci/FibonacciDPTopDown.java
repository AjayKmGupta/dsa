package practice.solution.dp.fibonacci;

import java.util.Arrays;

public class FibonacciDPTopDown {

    static long[] dp;

    public static void main(String[] args) {
        int n = 10;
        dp = new long[n + 1];

        Arrays.fill(dp, -1);

        System.out.println("Fib(" + n + ") = " + fibonacci(n));
    }


    private static long fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fibonacci(n - 1) + fibonacci(n-2);
        return dp[n];
    }

}
