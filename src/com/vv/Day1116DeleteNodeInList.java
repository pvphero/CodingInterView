package com.vv;

import com.vv.data.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/11/16
 */
public class Day1116DeleteNodeInList {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        //如果删除的是头节点的话 那么返回头节点的next节点
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        //如果cur不是尾指针，并且cur的value不是val的话  那么遍历next节点
        while (cur != null && cur.val != val) {
            //将pre指向cur，cur指向cur next
            pre = cur;
            cur = cur.next;
        }
        //将pre的next节点指向cur的next节点，删除cur
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

}
