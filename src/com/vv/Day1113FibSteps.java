package com.vv;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
