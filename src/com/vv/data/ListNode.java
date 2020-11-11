package com.vv.data;

/**
 * @author ShenZhenWei
 * @date 2020/11/11
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val) {
        this.value = val;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value + "");
            head = head.next;
        }
        return "ListNode{" + head + "}";
    }
}
