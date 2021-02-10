package com.vv.data;

/**
 * @author ShenZhenWei
 * @date 2020/11/11
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + "");
            head = head.next;
        }
        return "ListNode{" + sb.toString() + "}";
    }
}
