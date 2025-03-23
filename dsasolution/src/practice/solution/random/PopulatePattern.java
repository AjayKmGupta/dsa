/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.random;

import java.util.Scanner;

public class PopulatePattern {
    public static void main(String[] args) {
        PopulatePattern.getUserInput();
    }

    public static void getUserInput() {
        int rows = 0;
        int column = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of rows and cloumns value between 1 -10000 to create n dimension array \t");
        System.out.println("Please enter the number rows :");
        rows = sc.nextInt();
        System.out.println("Please enter the number columns :");
        column = sc.nextInt();
        int[][] patterArray = new int[rows][column];
        PopulatePattern.populatingPattern(patterArray, rows, column);
        PopulatePattern.printingPattern(patterArray, rows, column);
    }

    public static void populatingPattern(int[][] patterArray, int rows, int columns) {
        int patternValue = rows;
        int a = 0;
        while (a < rows) {
            int b = 0;
            while (b < columns) {
                patterArray[a][b] = patternValue++;
                ++b;
            }
            ++a;
        }
    }

    public static void printingPattern(int[][] patterArray, int rows, int columns) {
        int a = 0;
        while (a < rows) {
            int b = 0;
            while (b < columns) {
                System.out.print(patterArray[a][b] + "\t");
                ++b;
            }
            System.out.println();
            ++a;
        }
    }
}
