package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/28
 */
public class Day1228ReverseLinkedListIi {
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //迭代
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            //寻找 m的前node
            for (int i = 1; i < m; i++) {
                pre = pre.next;
            }
            //第m个 node为
            ListNode cur = pre.next;
            for (int i = m; i < n; i++) {
                //将cur处node 断开  将cur的next指向 cur的next next
                ListNode nxt = cur.next;
                cur.next = nxt.next;

                //将nxt放到pre的后面
                nxt.next = pre.next;
                pre.next = nxt;
            }
            return dummy.next;

        }
    }
}
