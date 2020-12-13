package com.vv;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/8
 */
public class Day1208Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    public static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            //使用动态数组保留所有的可能的全排列
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (len == 0) {
                return res;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<Integer>();
            dfs(nums, len, 0, path, used, res);
            System.out.println("dfs执行完毕===>" + res);
            return res;
        }

        public void dfs(int[] nums, int len, int depth,
                        List<Integer> path, boolean[] used,
                        List<List<Integer>> res) {
            System.out.println("递归开始：=>" + res);
            //递归的终止条件
            if (depth == len) {
                res.add(new ArrayList<Integer>(path));
                System.out.println("递归终止：==>" + res);
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    System.out.println("回溯之前：===>" + path);
                    dfs(nums, len, depth + 1, path, used, res);
                    //发生回溯
                    used[i] = false;
                    path.remove(path.size() - 1);
                    System.out.println("回溯之后：====>" + path);
                }
            }

        }
    }
}
