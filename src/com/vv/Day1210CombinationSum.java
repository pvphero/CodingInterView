package com.vv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节题库
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/10
 */
class Day1210CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(nums, 7));
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (len == 0) {
                return res;
            }
            Arrays.sort(candidates);
            List<Integer> path = new ArrayList<Integer>();
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        public void dfs(int[] nums, int depth, int len,
                        int target, List<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(path));
                return;
            }
            for (int i = depth; i < len; i++) {
                if (target - nums[i] < 0) {
                    //减枝
                    break;
                }
                path.add(nums[i]);
                dfs(nums, i, len, target - nums[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
