package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字节题库
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/21
 */
public class Day20210121BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorderTree(root, res);
            return res;
        }

        private void inorderTree(TreeNode root, List<Integer> list) {
            //递归终止条件
            if (root == null) {
                return;
            }
            inorderTree(root.left, list);
            list.add(root.val);
            inorderTree(root.right, list);
        }
    }

}
