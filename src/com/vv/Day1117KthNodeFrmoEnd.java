package com.vv;

import com.vv.data.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/17
 */
public class Day1117KthNodeFrmoEnd {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(getKthNodeEnd(listNode1, 2).val + "");
    }

    public static ListNode getKthNodeEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        if (head == null || k == 0) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            if (pre == null && i < k) {
                return null;
            }
            pre = pre.next;
        }
        while (pre != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return cur;
    }

}
