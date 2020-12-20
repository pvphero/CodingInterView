package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2020/12/20
 */
public class Day1220BinaryTreeRightSideView {
    public static void main(String[] args) {

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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();

            dfs(root, 0, res);
            return res;

        }

        private void dfs(TreeNode root, int depth, List<Integer> res) {
            if (root == null) {
                return;
            }
            //先访问当前节点，在递归访问右子树  左子树
            if (depth == res.size()) {
                //如果当前节点所在深度还没有出现res里，说明当前深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
                res.add(root.val);
            }
            depth++;
            dfs(root.right, depth, res);
            dfs(root.left, depth, res);
        }
    }
}
