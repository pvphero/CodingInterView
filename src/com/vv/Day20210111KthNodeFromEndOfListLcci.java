package com.vv;

import com.vv.data.ListNode;

/**
 * @author ShenZhenWei
 * @date 2021/1/11
 */
class Day20210111KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(solution.kthToLast(l1, 2));
    }

    static class Solution {
        public int kthToLast(ListNode head, int k) {
            //双指针
            ListNode fast = head;
            ListNode slow = head;

            while (k > 0) {
                fast = fast.next;
                k--;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.val;

        }
    }
}
