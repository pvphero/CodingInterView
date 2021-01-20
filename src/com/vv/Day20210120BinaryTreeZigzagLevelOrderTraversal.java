package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 字节题库
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/1/20
 */
public class Day20210120BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            //BFS
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            boolean leftToRight = true;
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();
                for (int i = 0; i < queue.size(); i++) {

                    TreeNode node = queue.poll();

                    if (leftToRight) {
                        level.add(node.val);
                    } else {
                        level.add(0, node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(level);
                leftToRight = !leftToRight;
            }
            return res;

        }
    }
}
