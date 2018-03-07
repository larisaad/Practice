package dp;
import java.util.Scanner;

/***
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(n*total)
 * Space complexity - O(n*total)
 *
 */

public class SubsetSum {


    private static int total, n;
    private static int[] numbers;

    static {
        Scanner mySc = new Scanner(System.in);
        total = mySc.nextInt();
        n = mySc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = mySc.nextInt();
        }

    }

    public static boolean[][] computeResult() {

        boolean[][] T = new boolean[numbers.length][total + 1];
        for (int i = 0; i < numbers.length; i++) {
            T[i][0] = true;
        }

        for (int j = 1; j < total + 1; j++) {
            if (j == numbers[0]) {
                T[0][j] = true;
            } else {
                T[0][j] = false;
            }
        }

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (j < numbers[i]) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j - numbers[i]] | T[i - 1][j];
                }
            }
        }
        return T;
    }

    public static void findSubset(boolean[][] T, int i, int j) {

        while (i > 0 && j > 0) {
            if (T[i][j] != T[i - 1][j]) {
                System.out.print(numbers[i] + " ");
                j -= numbers[i];
                i--;
            } else {
                i--;
            }
        }
    }

    public static void main(String[] args) {

        boolean[][] T = computeResult();
        if (T[numbers.length - 1][total]) {
            System.out.println("We can build a subsequence of total " + total);
            findSubset(T, numbers.length - 1, total);
        }

    }
}
