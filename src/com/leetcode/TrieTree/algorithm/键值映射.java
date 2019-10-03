package com.leetcode.TrieTree.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/9/28 20:38
 */
public class 键值映射 {

    class MapSum {
        public Node root;


        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node(0);
        }

        public void insert(String key, int val) {
            if(key == null)
            {
                root.isLeaf = true;
                root.value = val;
                return;
            }
            char[] keys = key.toCharArray();
            Node cur = root;
            for(char c : keys)
            {
                if(cur.map.containsKey(c))
                {
                    cur = cur.map.get(c);
                }
                else
                {
                    cur.map.put(c,new Node(0));
                    cur = cur.map.get(c);
                }
            }
            cur.isLeaf = true;
            cur.value = val;
        }

        public int sum(String prefix) {
            char[] prefixs = prefix.toCharArray();
            Node cur = root;
            for(char c:prefixs)
            {
                if(cur.map.containsKey(c))
                {
                    cur = cur.map.get(c);
                }else
                {
                    return 0;
                }
            }

            return computeSum(cur);
        }

        private int computeSum(Node cur)
        {
            int sum = 0;
            if(cur.isLeaf)
            {
                sum += cur.value;
            }

            for(Character c : cur.map.keySet())
            {
                sum += computeSum(cur.map.get(c));
            }
            return sum;
        }
    }


    class Node{
        public HashMap<Character,Node> map;
        public int value;
        public boolean isLeaf;

        public Node(int value)
        {
            map = new HashMap<>();
            this.value = value;
            isLeaf =false;
        }
    }
}
