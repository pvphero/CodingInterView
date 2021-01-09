package com.vv;

import com.vv.data.ListNode;

import java.util.Stack;

/**
 * 链表相关
 * 445. 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/9
 */
public class Day20210109AddTwoNumbersIi {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //利用栈，将两个链表压入栈中
            Stack<Integer> stack1 = new Stack<Integer>();
            Stack<Integer> stack2 = new Stack<Integer>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            //定义进位
            int carry = 0;
            //循环取出栈内的元素并相加
            ListNode head = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
                int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
                ListNode node = new ListNode(sum % 10);

                //因为相加的元素是尾部相加，所以利用头插发进行相加
                node.next = head;
                head = node;
                carry = sum / 10;
            }
            return head;
        }
    }
}
