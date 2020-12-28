package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/28
 */
public class Day1228RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            ListNode cur = dummy;
            while (fast != null) {
                cur = cur.next;
                fast = fast.next;
            }
            cur.next = cur.next.next;
            return dummy.next;

        }
    }
}
