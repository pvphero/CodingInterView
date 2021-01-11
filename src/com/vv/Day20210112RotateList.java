package com.vv;

import com.vv.data.ListNode;

/**
 * 链表
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/13
 */
public class Day20210112RotateList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(solution.rotateRight(l1, 2));
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            //双指针
            ListNode fast = head;
            ListNode slow = head;
            //将快指针移动到尾端
            int len = 1;
            while (fast.next != null) {
                len++;
                fast = fast.next;
            }

            //将链表连成环
            fast.next = slow;
            //将slow指针移动到要移动的位置

            int setp = len - k % len;
            while (setp-- > 1) {
                slow = slow.next;
            }

            //断开slow
            ListNode tmp = slow.next;
            slow.next = null;
            return tmp;

        }
    }

}
