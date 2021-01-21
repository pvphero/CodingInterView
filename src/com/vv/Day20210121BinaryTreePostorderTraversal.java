package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的遍历
 * 145. 二叉树的后序遍历
 * 难度
 * 中等
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author ShenZhenWei
 * @date 2021/1/21
 */
public class Day20210121BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            postorderTree(root, res);
            return res;
        }

        private void postorderTree(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postorderTree(root.left, list);
            postorderTree(root.right, list);
            list.add(root.val);

        }

    }

}
