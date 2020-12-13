package com.vv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShenZhenWei
 * @date 2020/12/13
 */
public class Day1213Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            if (len == 0) {
                return res;
            }
            dfs(nums, len, 0, path, res);
            return res;
        }

        private void dfs(int[] nums, int len, int start, List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<Integer>(path));

            for (int i = start; i < len; i++) {
                path.add(nums[i]);
                dfs(nums, len, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }

    }
}
