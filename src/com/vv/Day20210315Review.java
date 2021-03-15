package com.vv;

import com.vv.data.ListNode;

/**
 * @author ShenZhenWei
 * @date 2021/3/15
 */
public class Day20210315Review {
    public static void main(String[] args) {

    }

    /**
     * 找出链表中环的入口节点
     * <p>
     * 思路：快慢指针，快指针一次走两步，慢指针一次走一步，如果相等说明有环。
     * 在相等处，定一个头指针，从head开始一步一步走，然后相等处的slow指针一步一步走，直到两个相等
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            //注意结束条件，fast为null说明不成环，faste.next不为null  是保护快指针
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode h = head;
                while (h != slow) {
                    h = h.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
