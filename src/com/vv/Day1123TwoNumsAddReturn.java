package com.vv;

import com.vv.data.ListNode;

/**
 * 两个链表生成相加链表
 * <p>
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * 示例1
 * 输入
 * 复制
 * [9,3,7],[6,3]
 * 返回值
 * 复制
 * {1,0,0,0}
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=194&&tqId=35804&rp=1&ru=/ta/job-code-high-client&qru=/ta/job-code-high-client/question-ranking
 *
 * @author ShenZhenWei
 * @date 2020/11/23
 */
public class Day1123TwoNumsAddReturn {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        System.out.println(l1.toString());

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(3);
        System.out.println(l2.toString());
        ListNode sumListNode = addInList(l1, l2);
        System.out.println(sumListNode.toString());

    }

    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode l1 = returnListNode(head1);
        ListNode l2 = returnListNode(head2);
        ListNode dumry = new ListNode(0);
        ListNode head = dumry;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 != null ? l1.value : 0;
            int val2 = l2 != null ? l2.value : 0;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        ListNode resultNode = returnListNode(dumry.next);
        return resultNode;
    }

    public static ListNode returnListNode(ListNode head) {
        if (head == null) {
            return null;
        }
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
