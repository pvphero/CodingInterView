package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的遍历
 * 144. 二叉树的前序遍历
 *
 * @author ShenZhenWei
 * @date 2021/1/21
 */
public class Day20210121BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            preorderTree(root, res);
            return res;
        }

        private void preorderTree(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            preorderTree(root.left, list);
            preorderTree(root.right, list);
        }
    }
}
