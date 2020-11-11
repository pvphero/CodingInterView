package com.vv;

import com.vv.data.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author ShenZhenWei
 * @date 2020/11/9
 */
public class Day1109PrintListInReversedOrder {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] result = reversePrint(listNode1);
        int[] result2 = reversePrintByStack(listNode1);
        for (int a : result) {
            System.out.println(a);
        }
        for (int a : result2) {
            System.out.println(a);
        }
    }

    //方法一：

    /**
     * 1.遍历链表，获取节点的长度length
     * 2.创建长度为length的数组
     * 3.遍历链表，将链表节点的值赋值到数据的尾部
     * 时间复杂度O(n),空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode currentListNode = head;
        if (currentListNode == null) {
            return new int[]{};
        }
        //1.遍历链表，获取节点的长度length
        while (currentListNode != null) {
            length++;
            currentListNode = currentListNode.next;
        }

        int[] result = new int[length];
        int index = length - 1;
        currentListNode = head;
        while (currentListNode != null) {
            result[index] = currentListNode.value;
            currentListNode = currentListNode.next;
            index--;
        }
        return result;

    }

    public static int[] reversePrintByStack(ListNode head) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode currentListNode=head;
        while (currentListNode!=null){
            stack.push(currentListNode);
            currentListNode=currentListNode.next;
        }

        int[] result=new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            result[i]=stack.pop().value;
            i++;
        }
        return result;
    }


}
