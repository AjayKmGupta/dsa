package practice.solution.dp.fibonacci;

public class FibonacciDPBottomUp {

    static long[] dp;

    public static void main(String[] args) {

        int n = 5;

        dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        fibo(n);

        System.out.println("Fib(" + n + ") = " + dp[n]);
    }

    private static void fibo(int n) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

}
