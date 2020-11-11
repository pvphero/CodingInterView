package com.vv;

import com.vv.data.TreeNode;

/**
 * 剑指offer
 * 面试题8：二叉树的下一个节点
 * 给定一个二叉树和其中过一个节点，如何找出中序遍历
 * 序列的下一个节点？
 * 树的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针
 * <p>
 * <p>
 * 1.如果有右子树
 * next--->最左
 * 2.如果没有右子树
 * 父节点的左节点
 * next---->父节点
 * 父节点的右节点
 * next---->顺着父节点往上找，找到一个节点，当前节点是这个节点的左节点，如果存在，找到，
 * 若不存在，则当前节点为最后一个节点
 *
 * @author ShenZhenWei
 * @date 2020/11/11
 */
public class Day1111NextNodeInBinnaryTrees {
    public static void main(String[] args) {

    }

    public TreeNode finNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode nextNode = null;
        if (node.right != null) {
            TreeNode rightNode = node.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            nextNode = rightNode;
        } else if (node.parent != null) {
            TreeNode currentNode = node;
            TreeNode parentNode = node.parent;
            while (parentNode != null && currentNode == parentNode.right) {
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            nextNode = parentNode;
        }
        return nextNode;
    }
}
