package com.vv;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/12
 */
public class Day1212Combinations {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }


    public static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (k <= 0 || n < k) {
                return res;
            }
            List<Integer> path = new ArrayList<Integer>();
            dfs(n, k, 1, path, res);
            return res;
        }

        public void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i = start; i <= n; i++) {
                path.add(i);
                dfs(n, k, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
