package com.vv;

import java.util.Stack;

/**
 * @author ShenZhenWei
 * @date 2020/11/12
 */
public class Day1112QueueWithTwoStacks {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(5);
        obj.appendTail(7);
        int param_2 = obj.deleteHead();
    }

    static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1=new Stack<Integer>();
            stack2=new Stack<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty()?-1:stack2.pop();
        }
    }

}

