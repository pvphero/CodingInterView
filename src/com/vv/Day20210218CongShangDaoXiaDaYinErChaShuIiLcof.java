package com.vv;

import com.vv.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/2/18
 */
public class Day20210218CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            //bfs
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            boolean isLeftToRight = true;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if (root != null) {
                queue.add(root);
            }

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (isLeftToRight) {
                        level.add(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(level);
            }
            return res;


        }
    }

}
