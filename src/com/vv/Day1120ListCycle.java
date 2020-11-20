package com.vv;

import com.vv.data.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShenZhenWei
 * @date 2020/11/20
 */
public class Day1120ListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> setListNodeDate = new HashSet<ListNode>();
        while (head != null) {
            if (setListNodeDate.contains(head)) {
                return true;
            } else {
                setListNodeDate.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
