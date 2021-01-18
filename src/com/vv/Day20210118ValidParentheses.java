package com.vv;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 字节题库
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/18
 */
public class Day20210118ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>();
            pairs.put('(', ')');
            pairs.put('{', '}');
            pairs.put('[', ']');

            Deque<Character> stack = new LinkedList<Character>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty() && ch == pairs.get(stack.peek())) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();

        }
    }
}
