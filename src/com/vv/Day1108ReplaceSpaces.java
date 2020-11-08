package com.vv;

/**
 * @author ShenZhenWei
 * @date 2020/11/8
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Day1108ReplaceSpaces {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
