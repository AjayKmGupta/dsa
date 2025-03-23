/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.recursion;

public class TOH {
    public static void main(String[] args) {
        TOH.towerOfHanoi(2, 'A', 'B', 'C');
    }

    private static void towerOfHanoi(int n, char beg, char aux, char end) {
        if (n >= 1) {
            TOH.towerOfHanoi(n - 1, beg, end, aux);
            System.out.println(beg + "  " + end);
            TOH.towerOfHanoi(n - 1, aux, beg, end);
        }
    }
}
