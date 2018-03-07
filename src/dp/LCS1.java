package dp;
import java.util.Scanner;

/**
 * DP problem - Longest Common Subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n^2)
 */

public class LCS1 {

    private static String str1, str2;

    static {
        Scanner mySc = new Scanner(System.in);
        str1 = new String(mySc.nextLine());
        str2 = new String(mySc.nextLine());
    }
    private static int[][] computeMatrix() {

        int[][] T = new int[str2.length()+1][str1.length()+1];

        for (int j = 0; j < str1.length() + 1; j++) {
            T[0][j] = 0;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            T[i][0] = 0;
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    T[i][j] = 1 + T[i-1][j-1];
                } else {
                    T[i][j] = T[i-1][j] > T[i][j-1] ? T[i-1][j] : T[i][j-1];
                }
            }
        }
        return T;
    }

    private static String getLSC(int[][] T) {

        StringBuilder sol = new StringBuilder();
        int i = str2.length();
        int j = str1.length();
        while (i > 0 && j > 0 && T[i][j] != 0) {
            if (T[i][j] != T[i][j-1] && T[i][j] != T[i-1][j]) {
                sol.append(str2.charAt(i - 1));
                j--; i--;
            } else {
                if (T[i][j] == T[i][j-1]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return sol.reverse().toString();
    }

    public static void main (String[] args) {

        int[][] T = computeMatrix();
        System.out.println("LCS is of lenght: " + T[str2.length()][str1.length()]);
        System.out.println("LCS is " +  getLSC(T));


    }

}
