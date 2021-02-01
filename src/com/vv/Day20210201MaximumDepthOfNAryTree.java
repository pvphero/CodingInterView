package com.vv;

import com.vv.data.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 559. N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShenZhenWei
 * @date 2021/2/1
 */
public class Day20210201MaximumDepthOfNAryTree {
    public static void main(String[] args) {

    }


    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            } else if (root.children.isEmpty()) {
                return 1;
            } else {
                List<Integer> level = new LinkedList<Integer>();
                for (Node item : root.children) {
                    level.add(maxDepth(item));
                }
                return Collections.max(level) + 1;
            }
        }
    }

}
