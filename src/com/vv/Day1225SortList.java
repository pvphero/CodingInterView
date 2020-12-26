package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 148. 排序链表
 *
 *
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
