package dp;
import java.util.Scanner;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * Time complexity - O(noEggs * noFloors^2)
 * Space complexity - O(noEggs * noFloors)
 */

public class EggDropping {

    private static int noEggs, noFloors;

    static {
        Scanner mySc = new Scanner(System.in);
        noEggs = mySc.nextInt();
        noFloors = mySc.nextInt();
    }

    public static int solve() {

        int[][] T = new int[noEggs + 1][noFloors + 1];

        for (int j = 1; j <= noFloors; j++) {
            T[1][j] = j;

        }
        for (int i = 2; i <= noEggs; i++) {
            for (int j = 1; j <= noFloors; j++) {
                if (j < i) {
                    T[i][j] = T[i - 1][j];
                } else {
                    for (int k = 1; k <= j; k++) {
                        int max_tries = 1 + Math.max(T[i - 1][k - 1], T[i][j - k]);
                        if (T[i][j] == 0) {
                            T[i][j] = max_tries;
                        }
                        if (max_tries < T[i][j]) {
                            T[i][j] = max_tries;
                        }
                    }
                }
            }
        }

        return T[noEggs][noFloors];
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
