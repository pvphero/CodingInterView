package com.vv;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShenZhenWei
 * @date 2020/11/29
 */
class Day1129LRUCache {

    public static void main(String[] args) {
        Day1129LRUCache cache = new Day1129LRUCache(2);

        cache.put(1, 1); // 缓存是 {1=1}
        cache.put(2, 2); // 缓存是 {1=1, 2=2}
        cache.get(1);
        cache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        cache.get(2);    // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        cache.get(1);    // 返回 -1 (未找到)
        cache.get(3);    // 返回 3
        cache.get(4);    // 返回 4

//        cache.put(2,1);
//        cache.get(1);


    }

    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    Map<Integer, DoubleLinkedNode> map;
    int size;

    public Day1129LRUCache(int capactity) {
        head = new DoubleLinkedNode(0, -1);
        tail = new DoubleLinkedNode(0, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, DoubleLinkedNode>();
        size = capactity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            delete(node);
            add(node);
            System.out.println(node.val);
            return node.val;
        } else {
            System.out.println(-1);
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedNode curr = map.get(key);
            delete(curr);
            curr.val = value;
            add(curr);
        } else {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            add(newNode);
        }
    }

    private static class DoubleLinkedNode {
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        int val;
        int key;

        public DoubleLinkedNode(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public int getVal() {
            return val;
        }
    }

    private void delete(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.pre;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.pre = prev;
        map.remove(node.key);
    }

    private void add(DoubleLinkedNode newNode) {
        incertQueue(newNode);
        map.put(newNode.key, newNode);
        if (map.size() > size) {
            DoubleLinkedNode toBeDelete = tail.pre;
            delete(toBeDelete);
            map.remove(toBeDelete.key);
        }

    }

    private void incertQueue(DoubleLinkedNode node) {
        DoubleLinkedNode oldFirst = head.next;
        head.next = node;
        oldFirst.pre = node;
        node.pre = head;
        node.next = oldFirst;
    }
}
