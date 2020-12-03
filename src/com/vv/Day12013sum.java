package com.vv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节题库
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/1
 */
class Day12013sum {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSumWithTarget(a, 0);
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.get(i).size(); k++) {
                System.out.print(list.get(i).get(k));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        //1.对数组排序
        Arrays.sort(nums);
        //2.定义两个指针
        int low = start;
        int heigh = nums.length - 1;
        int sum = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (low < heigh) {
            sum = nums[low] + nums[heigh];
            //3.定义 left right保存nums[low] nums[heigh]的值
            int left = nums[low];
            int right = nums[heigh];
            if (sum < target) {
                while (low < heigh && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < heigh && nums[heigh] == right) {
                    heigh--;
                }
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(left);
                list.add(right);
                result.add(list);
                while (low < heigh && nums[low] == left) {
                    low++;
                }
                while (low < heigh && nums[heigh] == right) {
                    heigh--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumWithTarget(int[] nums, int target) {
        //1.排序
        Arrays.sort(nums);
        int n = nums.length;
        //穷举
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            //对 target-num[i] 计算twoSum
            List<List<Integer>> list = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> data : list) {
                data.add(nums[i]);
                res.add(data);
            }

            //跳出第一个数字重复的情况
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }


}
