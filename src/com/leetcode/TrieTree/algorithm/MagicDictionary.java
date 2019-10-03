package com.leetcode.TrieTree.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/9/28 21:05
 */
public class MagicDictionary {

        public Node root;

        /** Initialize your data structure here. */
        public MagicDictionary() {

            root = new Node();

        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {

            for(String s:dict)
            {
                insert(s);
            }

        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {

            if(word == null ) return false;

            char[] words = word.toCharArray();

            Node cur = root;
            int i = 0;
            for(i=0;i<words.length;i++)
            {
                if(cur.map.containsKey(words[i]))
                {
                    for(char c : cur.map.keySet())
                    {
                        if(c != words[i])
                        {
                            if(isExist(cur.map.get(c),words,i+1))
                                return true;
                        }
                    }
                    cur = cur.map.get(words[i]);
                }
                else
                {
                    for(char c : cur.map.keySet())
                    {
                        if(isExist(cur.map.get(c),words,i+1))
                            return true;
                    }
                    break;
                }
            }
            return false;
        }

        private boolean isExist(Node current, char[] words, int index)
        {
            Node cur = current;
            for(int i=index;i<words.length;i++)
            {
                if(cur.map.containsKey(words[i]))
                {
                    cur = cur.map.get(words[i]);
                }else
                {
                    return false;
                }
            }

            return cur.isLeaf;
        }


        private void insert(String s)
        {
            if(s == null)
            {
                root.isLeaf = true;
                return;
            }

            char[] word = s.toCharArray();
            Node cur = root;

            for(char c : word)
            {
                if(cur.map.containsKey(c))
                {
                    cur = cur.map.get(c);
                }
                else
                {
                    cur.map.put(c,new Node());
                    cur = cur.map.get(c);
                }
            }

            cur.isLeaf = true;
        }

    public static void main(String[] args) {

        MagicDictionary mg = new MagicDictionary();
        mg.buildDict(new String[]{"hello","leetcode"});
        System.out.println(mg.search("hello"));
    }
}



    class Node
    {
        public HashMap<Character, Node> map;
        public boolean isLeaf;

        public Node()
        {
            map = new HashMap<>();
            isLeaf = false;
        }
    }


