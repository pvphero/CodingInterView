package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/13
 */
public class Day1113FibSteps {
    public static void main(String[] args) {
        System.out.println(numWays(0));
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(7));
        System.out.println(numWays(45));
        System.out.println(numWays(44));
    }

    public static int numWays(int n) {
        int min1 = 1;
        int min2 = 2;
        int result = -1;
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else if (n <= 1) {
            return 1;
        } else if (n <= 2) {
            return 2;
        }
        for (int i = 3; i <= n; i++) {
            result = (min1 + min2) % 1000000007;
            min1 = min2;
            min2 = result;
        }
        return result;
    }
}
