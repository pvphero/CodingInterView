package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/5
 */
public class Day20210105RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                if (slow.next.val != fast.next.val) {
                    slow = slow.next;
                    fast = fast.next;
                } else {
                    while (fast != null && fast.next != null && slow.next.val == fast.next.val) {
                        fast = fast.next;
                    }
                    slow.next = fast.next;
                    fast = fast.next;
                }

            }
            return dummy.next;
        }
    }
}
