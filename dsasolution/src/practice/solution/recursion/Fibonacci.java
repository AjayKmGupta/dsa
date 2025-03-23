/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("0 1 ");
        Fibonacci.fib(0, 1, 6, 0);
        System.out.println();
        Fibonacci.fibonacciWithLoop(8);
    }

    private static void fib(int a, int b, int term, int currentTerm) {
        if (term == currentTerm) {
            return;
        }
        int sum = a + b;
        System.out.print(sum + " ");
        a = b;
        b = sum;
        Fibonacci.fib(a, b, term, currentTerm + 1);
    }

    private static void fibonacciWithLoop(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        System.out.print(a + " " + b + " ");
        int i = 1;
        while (i <= n - 2) {
            sum = a + b;
            System.out.print(sum + " ");
            a = b;
            b = sum;
            ++i;
        }
    }
}
