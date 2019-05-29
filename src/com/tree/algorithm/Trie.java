package com.tree.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/5/28 14:43
 */
public class Trie {

    /**
     * 通过HashMap来实现，更加灵活，不仅仅适用于小写字母
     */
    private class Node{
        public Map<Character, Node> child= new HashMap<>();
        public boolean isLeaf;
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        insert(word,root);
    }

    public void insert(String word, Node root)
    {
        if(root == null) return;
        if(word.isEmpty())
        {
            root.isLeaf = true;
            return;
        }
        Node cur = root;
        for(int i=0;i<word.length();i++)
        {
            Character c = word.charAt(i);
            if(cur.child.containsKey(c))
            {
                cur=cur.child.get(c);
                continue;
            }else
            {
                cur.child.put(c,new Node());
                cur = cur.child.get(c);
            }
        }
        cur.isLeaf = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       return search(word,root);
    }

    public boolean search(String word, Node root)
    {
        if(word.isEmpty()) return root.isLeaf;
        Node cur = root;
        for(int i=0;i<word.length();i++)
        {
            Character c = word.charAt(i);
            if(cur.child.containsKey(c)){
                cur=cur.child.get(c);
                continue;
            }
            else{
                return false;
            }
        }
        return cur.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       return startsWith(prefix,root);
    }

    public boolean startsWith(String prefix, Node root){
        if(root == null) return false;
        if(prefix.isEmpty()) return true;
        Node cur = root;
        for(int i=0;i<prefix.length();i++)
        {
            Character c = prefix.charAt(i);
            if(cur.child.containsKey(c)){
                cur=cur.child.get(c);
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
