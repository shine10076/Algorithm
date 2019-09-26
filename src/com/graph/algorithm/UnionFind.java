package com.graph.algorithm;

import java.util.HashMap;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/9/26 20:23
 */
public class UnionFind {

    public static class Node{

    }

    public static class UnionFindSet{

        //Key : child, value : father
        public HashMap<Node,Node> fatherMap;
        //Key : Node value : 表示Node在的集合的大小
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){

            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        private void makeSets(List<Node> nodes){

            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for(Node node : nodes)
            {
                fatherMap.put(node, node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node)
            {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b)
        {
            return findHead(a) == findHead(b);
        }

        public void Union(Node a, Node b)
        {
            if(a == null || b == null){
                return ;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize <= bSetSize)
                {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead,aSetSize+bSetSize);
                }
            }
        }

    }
}
