package dp;
import java.util.Scanner;

/**
 * DP String Interleaving
 * Time complexity - O(n^2)
 * Space complexity - O(n^2)
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 */

public class StringInterleaving {


    private static String str1, str2, str3;

    static {
        Scanner mySc = new Scanner(System.in);
        str1 = new String(mySc.nextLine());
        str2 = new String(mySc.nextLine());
        str3 = new String(mySc.nextLine());
    }


    public static boolean areInterleaving() {

        boolean[][] T = new boolean[str2.length() + 1][str1.length() + 1];
        T[0][0] = true;

        for (int j = 1; j < str1.length() + 1; j++) {
            T[0][j] = str3.charAt(j - 1) == str1.charAt(j - 1) ? true : false;
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            T[i][0] = str3.charAt(i - 1) == str2.charAt(i - 1) ? true : false;
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                T[i][j] = false;
                if (str3.charAt(i + j - 1) == str2.charAt(i - 1)) {
                    T[i][j] = T[i - 1][j];
                }
                if (str3.charAt(i + j - 1) == str1.charAt(j - 1)) {
                    T[i][j] = T[i][j - 1];
                }

            }
        }
        return T[str2.length()][str1.length()];
    }

    public static void main(String[] args) {

        if (areInterleaving()) {
            System.out.println("Strings are interleaving.");
        } else {
            System.out.println("Strings are not interleaving.");
        }
    }
}
