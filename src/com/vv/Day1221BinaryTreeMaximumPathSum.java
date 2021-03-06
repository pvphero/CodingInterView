package com.vv;

import com.vv.data.TreeNode;

/**
 * 字节题库
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：[-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出：42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/21
 */
public class Day1221BinaryTreeMaximumPathSum {
    public static void main(String[] args) {

    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        private int maxGain(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftGain = Math.max(maxGain(root.left), 0);
            int RightGain = Math.max(maxGain(root.right), 0);

            int priceNewPath = root.val + leftGain + RightGain;

            maxSum = Math.max(maxSum, priceNewPath);

            return root.val + Math.max(leftGain, RightGain);
        }
    }


}
