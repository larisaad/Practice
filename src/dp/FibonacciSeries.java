package dp;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-1/
 * Time complexity - O(n)
 * Space complexity - O(n)
 */

public class FibonacciSeries {

    private static int[] lookup;

    public static int fibonacci_bottom_up(int n) {

        int[] t = new int[n + 1];
        t[0] = 0;
        t[1] = 1;
        for (int i = 2; i <= n; i++) {
            t[i] = t[i - 1] + t[i - 2];
        }
        return t[n];

    }

    public static int fibonacci_recursive(int n) {

        if (lookup[n] == -1) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
            }
        }
        return lookup[n];
    }

    public static int fibonacci_top_down(int n) {

        lookup = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lookup[i] = -1;
        }
        return fibonacci_recursive(n);
    }

    public static void main(String[] args) {

        Scanner mySc = new Scanner(System.in);
        int n = mySc.nextInt();

        System.out.println(fibonacci_bottom_up(n));
        System.out.println(fibonacci_top_down(n));

    }
}
