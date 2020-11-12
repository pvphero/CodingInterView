package com.vv;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author ShenZhenWei
 * @date 2020/11/12
 */
public class Day1112StackWithTwoQueues {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        int size=stack.size();
        for (int i=0;i<size;i++){
            System.out.println(stack.pop());
        }
        stack.push(31321);
        System.out.println(stack.pop());
    }

    public static class MyStack {
        private Queue<Integer> q1 = new LinkedList<Integer>();
        private Queue<Integer> q2 = new LinkedList<Integer>();

        public void push(Integer value) {
            q1.offer(value);
        }

        public Integer pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return null;
            }

            if (!q1.isEmpty()) {
                int size=q1.size();
                for (int i = 0; i < size - 1; i++) {
                    q2.offer(q1.poll());
                }
                return q1.poll();
            } else {
                int size=q2.size();
                for (int i = 0; i < size - 1; i++) {
                    q1.offer(q2.poll());
                }
                return q2.poll();
            }

        }

        public int size(){
            return q1.size()+q2.size();
        }
    }


}
