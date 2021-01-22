package com.vv;

import com.vv.data.ListNode;

/**
 * 复习，牛客上直接开始考试
 *
 * @author ShenZhenWei
 * @date 2021/1/22
 */
class Day20210122Review {
    public static void main(String[] args) {

    }

    /**
     * 反转链表
     * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=117&tags=&title=&diffculty=0&judgeStatus=0&rp=1
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode tmp = null;
        while (current != null) {
            tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }


}
