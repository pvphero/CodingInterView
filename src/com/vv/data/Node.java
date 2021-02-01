package com.vv.data;

import java.util.List;

/**
 * @author ShenZhenWei
 * @date 2021/2/1
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
