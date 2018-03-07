package dp;
import java.util.Scanner;

/**
 * Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
 * <p>
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 */

public class CoinChanging {


    private static int total, n;
    private static int[] coins;

    static {
        Scanner mySc = new Scanner(System.in);
        total = mySc.nextInt();
        n = mySc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = mySc.nextInt();
        }

    }

    public static int[][] computeMatrix() {

        int[][] T = new int[coins.length][total + 1];

        for (int i = 0; i < coins.length; i++) {
            T[i][0] = 0;
        }

        for (int j = 0; j < total + 1; j++) {
            if (j < coins[0]) {
                T[0][j] = 0;
            } else {
                T[0][j] = 1 + T[0][j - coins[0]];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (j < coins[i]) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j] < 1 + T[i][j - coins[i]] ? T[i - 1][j] : 1 + T[i][j - coins[i]];
                }
            }
        }
        return T;
    }

    public static void getCoins(int[][] T, int i, int j) {

        while (i > 0 && j > 0) {
            if (T[i][j] != T[i - 1][j]) {
                System.out.print(coins[i] + " ");
                j -= coins[i];
            } else {
                i--;
            }
        }
    }

    public static void main(String[] args) {

        int[][] T = computeMatrix();
        System.out.println("Minimum no of coins is " + T[coins.length - 1][total]);
        getCoins(T, coins.length - 1, total);
    }
}
