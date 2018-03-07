package dp;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 * Input test:
 * 4 10 4 12 2 16 6 21 3
 * Time complexity = O(n^3);
 * Space complexity = O(n^2);
 */

public class OptimalBST {


    private static int n;
    private static int[] keys, costs;

    static {
        Scanner mySc = new Scanner(System.in);
        n = mySc.nextInt();
        keys = new int[n];
        costs = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = mySc.nextInt();
            costs[i] = mySc.nextInt();
        }
    }


    private static int sum(int x, int y) {
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum += costs[i];
        }
        return sum;
    }

    public static int solve() {
        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++) {
            T[i][i] = costs[i];
        }

        for (int l = 2; l <= n; l++) { // chain length
            for (int i = 0; i < n - l + 1; i++) { //line
                int j = i + l - 1; //column
                int sum = sum(i, j);
                for (int r = i; r <= j; r++) { // all possibilities to form a tree
                    int cost = ((r > i) ? T[i][r - 1] : 0)
                            + ((r < j) ? T[r + 1][j] : 0)
                            + sum;
                    if (T[i][j] == 0) {
                        T[i][j] = cost;
                    }
                    if (cost < T[i][j]) {
                        T[i][j] = cost;
                    }
                }

            }
        }

        return T[0][n - 1];

    }


    public static void main(String[] args) {

        System.out.println(solve());
    }
}
