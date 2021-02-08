package com.vv;

import com.vv.data.TreeNode;

/**
 * 树
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/2/8
 */
public class Day20210208BalancedBinaryTree {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                int left = height(root.left);
                int right = height(root.right);
                boolean isMaxLimit = (Math.abs(left - right) <= 1);
                boolean isLeftBalanced = isBalanced(root.left);
                boolean isRightBalanced = isBalanced(root.right);
                return isMaxLimit && isLeftBalanced && isRightBalanced;
            }
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left = height(root.left);
                int right = height(root.right);
                return Math.max(left, right) + 1;
            }
        }
    }

}
