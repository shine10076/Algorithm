package com.leetcode.design.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/5/4 17:15
 */
public class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer, LRUNode> map;
    private LRUNode head;
    private LRUNode tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;

        map = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);

        if (node == null) {
            node = new LRUNode(key, value);
            push(node);
            map.put(key, node);

            if (size > capacity) {
                pop();
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void push(LRUNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    private LRUNode pop() {
        if (size > 0) {
            LRUNode node = tail.pre;
            delete(node);
            map.remove(node.key);
            return node;
        } else {
            return null;
        }
    }

    private void delete(LRUNode node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;

    }

    private void moveToHead(LRUNode node) {
        delete(node);
        push(node);
    }

    public void printList() {
        LRUNode node = head;
        while (node != tail) {

            System.out.println(node.key + ":" + node.val);
            node = node.next;
        }
        System.out.println("size=" + size);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.printList();
    }
}

class LRUNode {
    int key;
    int val;
    LRUNode pre;
    LRUNode next;

    LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    LRUNode() {
    }
}
