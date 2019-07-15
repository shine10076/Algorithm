package com.leetcode.Search.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/7/12 19:31
 */
public class 单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            String a = wordList.get(i);
            map.put(a,new Node(a));
        }
        /**
         * 构建图
         */
        for(int i=0;i<wordList.size();i++)
        {
            String word = wordList.get(i);
            for(int j=0;j<wordList.size();j++)
            {
                if(i == j) continue;
                if(diffOne(word, wordList.get(j)))
                {
                    map.get(word).nodeList.add(map.get(wordList.get(j)));
                }

            }
        }
        int res = 0;
        /**
         * 广度遍历图
         */
        if(!map.containsKey(endWord)) return 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<wordList.size();i++)
        {
            if(diffOne(beginWord,wordList.get(i)))
            {
                queue.offer(map.get(wordList.get(i)));
                break;
            }
        }
        while(!queue.isEmpty())
        {
            Queue<Node> q = new LinkedList<>();
            while (!queue.isEmpty())
            {
                Node cur = queue.poll();
                if(cur.word == endWord) return ++res;
                set.add(cur);
                for(Node n:cur.nodeList)
                {
                    if(!set.contains(n))
                       q.offer(n);
                }
            }
            res++;
            for(Node n:q)
            {
                queue.offer(n);
            }
        }
        return res;
    }

    public boolean diffOne(String a, String b)
    {
        if(a.length() != b.length())
        {
            return false;
        }
        int res = 0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i) != b.charAt(i)) res++;
        }
        return res==1;
    }


    class Node{
        public String word;
        public List<Node> nodeList;

        public Node(String word)
        {
            this.word = word;
            nodeList = new ArrayList<>();
        }
    }
}
