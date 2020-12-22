package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/22
 */
public class Day1222BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;

        node2.left = node1;
        node3.left = node2;
        node4.left = node3;
        node5.left = node4;
        node6.left = node5;

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(node1));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root != null) {
                dfs(root, 0, res);
            }
            return res;
        }

        private void dfs(TreeNode root, int depth, List<List<Integer>> res) {
            if (res.size() - 1 < depth) {
                res.add(new ArrayList<Integer>());
            }
            res.get(depth).add(root.val);
            if (root.left != null) {
                dfs(root.left, depth + 1, res);
            }
            if (root.right != null) {
                dfs(root.right, depth + 1, res);
            }
        }


    }
}
