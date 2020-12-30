package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/30
 */
public class Day1229SwapNodesInPairs {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                ListNode slow = cur.next;
                ListNode fast = cur.next.next;
                cur.next = fast;
                slow.next = fast.next;
                fast.next = slow;
                cur = slow;
            }
            return dummy.next;
        }
    }
}
