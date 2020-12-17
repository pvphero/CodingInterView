package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/12/17
 */
public class Day1217ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(44));
    }

    static class Solution {
        public int climbStairs(int n) {
            int min1 = 1;
            int min2 = 2;
            if (n < 0) {
                return -1;
            } else if (n <= 1) {
                return 1;
            } else if (n <= 2) {
                return 2;
            }
            int res = -1;
            for (int i = 3; i <= n; i++) {
                res = min1 + min2;
                min1 = min2;
                min2 = res;
            }
            return res;
        }
    }
}
