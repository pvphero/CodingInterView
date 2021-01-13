package com.vv;

import com.vv.data.ListNode;

/**
 * 链表
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
