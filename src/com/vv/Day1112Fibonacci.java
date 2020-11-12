package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/12
 */
class Day1112Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(45));

    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int min1 = 0;
        int min2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (min1 + min2) % 1000000007;
            min1 = min2;
            min2 = result;
        }
        return result;
    }

}
