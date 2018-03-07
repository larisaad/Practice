package dp;
import java.util.Scanner;

/**
 * Find a subsequence in given array in which the subsequence's elements are
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible.
 * Time complexity is O(n^2).
 * Space complexity is O(n).
 * <p>
 * An O(nlogn) solution:  https://www.geeksforgeeks.org/construction-of-longest-monotonically-increasing-subsequence-n-log-n/
 */


public class LIS {


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

    public static int getLIS() {

        int[] T = new int[n];
        int max = 0;
        T[0] = 1;
        for (int i = 1; i < n; i++) {
            T[i] = 1; //dp.LIS is at least 1 for each element
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (T[i] < 1 + T[j]) {
                        T[i] = 1 + T[j];
                        if (T[i] > max) {
                            max = T[i];
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(getLIS());
    }
}
