package dp;
import java.util.Scanner;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Time complexity -  O(m * n)
 * Space complexity - O(m * n)
 *
 */

public class MinEditDistance {

    private static String str1, str2;
    static {
        Scanner mySc = new Scanner(System.in);
        str1 = new String(mySc.nextLine());
        str2 = new String(mySc.nextLine());
    }

    public static int getMinimum(int a, int b, int c) {
        int aux = a < b ? a : b;
        return aux < c ? aux : c;
    }

    public static int getMinEditDistance() {

        int[][] T = new int[str1.length() + 1][str2.length() + 1];
        for (int j = 0; j <= str2.length(); j++) {
            T[0][j] = j;
        }

        for (int i = 0; i <= str1.length(); i++) {
            T[i][0] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1];
                } else {
                    T[i][j] = 1 + getMinimum(T[i][j - 1], T[i - 1][j - 1], T[i - 1][j]);
                }
            }
        }

        return T[str1.length()][str2.length()];
    }

    public static void main (String[] args) {

        System.out.println(getMinEditDistance());
    }
}
