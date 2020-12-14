package com.vv;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 90. 子集 II
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/14
 */
public class Day1214SubsetsII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            dfs(nums, len, 0, path, res);
            return res;
        }

        private void dfs(int[] nums, int len, int start, List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<Integer>(path));
            for (int i = start; i < len; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                dfs(nums, len, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
