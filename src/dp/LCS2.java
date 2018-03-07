package dp;
import java.util.Scanner;

/**
 * DP Longest Common Substring
 * Time complexity - O(n^2)
 * Space complexity - O(n^2)
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 */

public class LCS2 {

    private static String str1, str2;

    static {
        Scanner mySc = new Scanner(System.in);
        str1 = new String(mySc.nextLine());
        str2 = new String(mySc.nextLine());
    }

    public static void solve() {

        int[][] T = new int[str2.length() + 1][str1.length() + 1];
        int maxlen = 0, maxi = -1, maxj = -1;


        for (int i = 0; i < str2.length() + 1; i++) {
            T[i][0] = 0;
        }

        for (int j = 0; j < str1.length() + 1; j++) {
            T[0][j] = 0;
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    if (T[i][j] > maxlen) {
                        maxlen = T[i][j];
                        maxi = i;
                        maxj = j;
                    }
                } else {
                    T[i][j] = 0;
                }
            }
        }

        System.out.println("LCS's length is " + maxlen);
        System.out.println("LCS is " + computeLCS(T, maxi, maxj));

    }

    public static String computeLCS(int[][] T, int i, int j) {

        StringBuilder sol = new StringBuilder();
        while (i > 0 && j > 0 && T[i][j] != 0) {
            sol.append(str2.charAt(i - 1));
            i--;
            j--;
        }
        return sol.reverse().toString();
    }

    public static void main(String[] args) {
        solve();
    }
}
