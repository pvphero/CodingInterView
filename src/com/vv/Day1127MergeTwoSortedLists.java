package com.vv;

import com.vv.data.ListNode;

/**
 * 字节题库
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/27
 */
public class Day1127MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        System.out.println(l1.toString());

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(l2.toString());

        System.out.println(mergeTwoLists(l1, l2).toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }

        }
        return dum.next;
    }
}
