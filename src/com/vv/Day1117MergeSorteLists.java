package com.vv;

import com.vv.data.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/17
 */
class Day1117MergeSorteLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(mergeTowLists(listNode1, listNode2).value + "");
    }

    public static ListNode mergeTowLists(ListNode l1, ListNode l2) {
        //快慢指针，一个遍历l1 一个遍历l2，如果为null则结束循环
        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return dum.next;
    }
}
