package dp;
import java.util.Scanner;

/**
 *
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are in increasing order.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */

public class MSIS {

    private static int n;
    private static int[] arr;

    static {
        Scanner mySc = new Scanner(System.in);
        n = mySc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = mySc.nextInt();
        }
    }

    public static void solve() {
        int[] maxsum = new int[n];
        int[] P = new int[n];

        int max = 0, posmax = -1;
        for (int i = 0; i < n; i++) {
            maxsum[i] = arr[i];
            P[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0;  j < i; j++) {

                if (arr[j] < arr[i]) {
                    if (maxsum[i] < maxsum[j] + arr[i]) {
                        maxsum[i] = maxsum[j] + arr[i];
                        P[i] = j;
                        if (max < maxsum[i]) {
                            max = maxsum[i];
                            posmax = i;
                        }
                    }
                }
            }
        }

        System.out.println("Maximum Sum Increasing Subsequence is " + max);

        System.out.println();
        getMSIS(P, posmax);

    }

    public static void getMSIS(int[] P, int x) {

        StringBuilder sol = new StringBuilder();
        while(x != P[x]) {
            sol.append(arr[x]);
            sol.append(" ");
            x = P[x];
        }
        sol.append(arr[x]);
        System.out.println(sol.reverse().toString());
    }

    public static void main(String[] args) {
        solve();
    }
}
