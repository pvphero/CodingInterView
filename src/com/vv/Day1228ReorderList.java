package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/28
 */
public class Day1228ReorderList {
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
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            //快慢指针找链表中点
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //将链表截成两段
            ListNode bigListNode = slow.next;
            slow.next = null;

            //将大的链表进行反转
            bigListNode = reverList(bigListNode);

            while (bigListNode != null) {
                ListNode tmp = bigListNode.next;
                bigListNode.next = head.next;

                head.next = bigListNode;

                head = bigListNode.next;
                bigListNode = tmp;
            }
        }

        private ListNode reverList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode tmp = null;
            while (cur != null) {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }

}
