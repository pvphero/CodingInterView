package com.vv;

import com.vv.data.ListNode;
import com.vv.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 * <p>
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/2/10
 */
public class Day20210210ListOfDepthLcci {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            ListNode[] res = new ListNode[depth(tree)];
            if (tree == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            //idx指向层数 从0开始
            int idx = 0;
            queue.add(tree);
            while (!queue.isEmpty()) {
                //size统计每层的节点个数
                int size = queue.size();
                //虚拟头节点
                ListNode dumy = new ListNode();
                //tmp用来连接链表
                ListNode tmp = dumy;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ListNode cur = new ListNode();
                    cur.val = node.val;
                    tmp.next = cur;
                    tmp = cur;


                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

                }
                res[idx++] = dumy.next;
            }
            return res;
        }

        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left = depth(root.left);
                int right = depth(root.right);
                return Math.max(left, right) + 1;
            }

        }
    }
}
