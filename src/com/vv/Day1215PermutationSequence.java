package com.vv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShenZhenWei
 * @date 2020/12/15
 */
public class Day1215PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(9, 25996));
    }

    static class Solution {
        public String getPermutation(int n, int k) {

            List<List<String>> res = new ArrayList<List<String>>();
            res = getResList(n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(res.get(k - 1).get(i) + "");
            }
            return sb.toString();

        }


        public List<List<String>> getResList(int n) {
            List<String> list = new ArrayList<String>();
            for (int i = 1; i <= n; i++) {
                list.add(i + "");
            }
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>();
            boolean[] used = new boolean[n];
            dfs(list, n, used, path, res);
            return res;
        }

        public void dfs(List<String> nums, int len, boolean[] used, List<String> path, List<List<String>> res) {
            if (path.size() == len) {
                res.add(new ArrayList<String>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums.get(i));
                    used[i] = true;
                    dfs(nums, len, used, path, res);

                    used[i] = false;
                    path.remove(path.size() - 1);
                }

            }
        }
    }
}
