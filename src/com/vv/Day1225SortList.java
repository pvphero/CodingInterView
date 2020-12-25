package com.vv;

import com.vv.data.ListNode;

/**
 * @author ShenZhenWei
 * @date 2020/12/26
 */
public class Day1225SortList {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
        public ListNode sortList(ListNode head) {
            //递归终止条件
            if (head == null || head.next == null) {
                return head;
            }
            //定义两个指针  快慢指针
            ListNode fast = head.next;
            ListNode slow = head;
            //快指针 每次走两步，慢指针每次走一步
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //定义临时变量 存slow.next,这个是第二部分的头节点
            ListNode tmp = slow.next;
            //将链表 cut
            slow.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;

            //合并
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            if (left != null) {
                h.next = left;
            } else {
                h.next = right;
            }
            return res.next;
        }
    }
}
