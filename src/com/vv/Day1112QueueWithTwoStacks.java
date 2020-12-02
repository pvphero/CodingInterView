package com.vv;

import java.util.Stack;

/**
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 *
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
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }


//    vector<vector<int>> twoSumTarget(vector<int>& nums,int start, int target) {
//        // nums 数组必须有序
//        sort(nums.begin(), nums.end());
//        int lo = start, hi = nums.size() - 1;
//        vector<vector<int>> res;
//        while (lo < hi) {
//            int sum = nums[lo] + nums[hi];
//            int left = nums[lo], right = nums[hi];
//            if (sum < target) {
//                while (lo < hi && nums[lo] == left) lo++;
//            } else if (sum > target) {
//                while (lo < hi && nums[hi] == right) hi--;
//            } else {
//                res.push_back({left, right});
//                while (lo < hi && nums[lo] == left) lo++;
//                while (lo < hi && nums[hi] == right) hi--;
//            }
//        }
//        return res;
//    }
//
//    /* 计算数组 nums 中所有和为 target 的三元组 */
//    vector<vector<int>> threeSumTarget(vector<int>& nums, int target) {
//        // 数组得排个序
//        sort(nums.begin(), nums.end());
//        int n = nums.size();
//        vector<vector<int>> res;
//        // 穷举 threeSum 的第一个数
//        for (int i = 0; i < n; i++) {
//            // 对 target - nums[i] 计算 twoSum
//            vector<vector<int>>
//                    tuples = twoSumTarget(nums, i + 1, target - nums[i]);
//            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
//            for (vector<int>& tuple : tuples) {
//                tuple.push_back(nums[i]);
//                res.push_back(tuple);
//            }
//            // 跳过第一个数字重复的情况，否则会出现重复结果
//            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
//        }
//        return res;
//    }

}

