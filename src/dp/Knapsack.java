package dp;
import java.util.Scanner;

/**
 * 0/1 dp.Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 * Time complexity - O(w*total items)
 */

public class Knapsack {

    private static int totalWeight, noItems;
    private static int[] w;
    private static int[] v;

    static {
        Scanner mySc = new Scanner(System.in);
        totalWeight = mySc.nextInt();
        noItems = mySc.nextInt();
        w = new int[noItems];
        v = new int[noItems];
        for (int i = 0; i < noItems; i++) {
            w[i] = mySc.nextInt();
            v[i] = mySc.nextInt();
        }

    }

    public static int[][] computeMatrix() {

        int[][] T = new int[noItems][totalWeight + 1];
        for (int i = 0; i < noItems; i++) {
            T[i][0] = 0;
        }

        for (int j = 1; j < totalWeight + 1; j++) {
            if (j < w[0]) {
                T[0][j] = 0;
            } else {
                T[0][j] = v[0];
            }
        }

        for (int i = 1; i < noItems; i++) {
            for (int j = 1; j < totalWeight + 1; j++) {
                if (j < w[i]) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j] > v[i] + T[i - 1][j - w[i]] ? T[i - 1][j] : v[i] + T[i - 1][j - w[i]];
                }
            }
        }
        return T;
    }


    public static void printSelectedObjects(int[][] T) {


        int i = noItems - 1;
        int j = totalWeight;
        while (T[i][j] != 0 && i > 0 && j > 0) {
            if (i > 0) {
                if (T[i][j] == T[i - 1][j]) {
                    i--;
                } else {
                    System.out.println("Object with weight = " + w[i] + " and value = " + v[i] + " is selected.");
                    j -= w[i];
                    i--;

                }
            }
        }

    }

    public static void main(String[] args) {

        int[][] T = computeMatrix();
        System.out.println("The maximum value that can be obtained is: " + T[noItems - 1][totalWeight]);
        printSelectedObjects(T);
    }
}
