package com.vv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节题库
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/11
 */
class Day1211CombinationSumII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution.combinationSum2(nums, 8));
    }

    public static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (len == 0) {
                return res;
            }
            List<Integer> path = new ArrayList<Integer>();
            boolean[] used = new boolean[len];
            Arrays.sort(candidates);
            dfs(candidates, len, 0, target, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         int target, List<Integer> path,
                         boolean[] used, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i = depth; i < len; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                if (target - nums[i] < 0) {
                    break;
                }
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, i, target - nums[i], path, used, res);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }


    }
}
