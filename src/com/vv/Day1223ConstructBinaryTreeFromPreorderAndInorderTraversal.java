package com.vv;

import com.vv.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShenZhenWei
 * @date 2020/12/23
 */
public class Day1223ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildTree(new int[]{3, 9, 20, 15,}, new int[]{9, 3, 15, 20, 7}));
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
            int length = preorder.length;
            for (int i = 0; i < length; i++) {
                indexMap.put(inorder[i], i);
            }
            TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
            return root;
        }

        private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                                   int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {

            //开始大于结束，则当前的二叉树没有节点，返回null
            if (preorderStart > preorderEnd) {
                return null;
            }
            //跟节点的值为前序遍历的第一个节点的值
            int rootVal = preorder[preorderStart];
            //将根节点的值放入到树中
            TreeNode root = new TreeNode(rootVal);

            //开始等于结束，则当前的二叉树恰好一个节点，根据节点值创建该节点作为根节点返回
            if (preorderStart == preorderEnd) {
                return root;
            } else {
                //从中序遍历的数组中获取，根节点的下标位置
                int rootIndex = indexMap.get(rootVal);
                //中序变遍历跟节点左边为左子树，右边为右子树
                //获取左子树的节点数目
                int leftNodes = rootIndex - inorderStart;
                //获取右子树的节点数目
                int rightNodes = inorderEnd - rootIndex;
                //构建左子树
                TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                        inorder, inorderStart, rootIndex - 1, indexMap);

                //构建右子树
                TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                        inorder, rootIndex + 1, inorderEnd, indexMap);

                root.left = leftSubtree;
                root.right = rightSubtree;
                return root;
            }


        }
    }

}
