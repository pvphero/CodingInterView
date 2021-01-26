package com.vv;

/**
 * 字节题库
 * 9. 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 *
 * @author ShenZhenWei
 * @date 2021/1/26
 */
public class Day20210126PalindromeNumber {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPalindrome(int x) {
            //负数一定不是回文数
            if (x < 0) {
                return false;
            }
            //将这个数翻过来，如果跟之前的数相等，那么就是回文数
            int num = x;
            int cur = 0;
            while (num != 0) {
                cur = cur * 10 + num % 10;
                num = num / 10;
            }
            return cur == x;

        }
    }

}
