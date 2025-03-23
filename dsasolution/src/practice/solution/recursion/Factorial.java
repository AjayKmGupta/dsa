/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(Factorial.fact(5));
        System.out.println(Factorial.factWithLoop(6));
    }

    private static int fact(int i) {
        if (i <= 1) {
            return 1;
        }
        return i * Factorial.fact(i - 1);
    }

    private static int factWithLoop(int n) {
        int fact = 1;
        int i = n;
        while (i > 0) {
            fact *= i;
            --i;
        }
        return fact;
    }
}
