package com.leetcode.graph.algorithm;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/10/14 19:54
 */
public class 课程表 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            Node node = new Node(i);
            list.add(node);
        }
        /**
         * 添加依赖关系
         */
        for(int[] nums: prerequisites)
        {
            int end = nums[0];
            int start = nums[1];
            list.get(start).nexts.add(list.get(end));
        }

        HashSet<Node> isVisited = new HashSet<>();

        for(Node node : list)
        {
            if(!isCycle(node,isVisited)) return false;
        }

        return true;
    }


    public boolean isCycle(Node node, HashSet<Node> isVisited)
    {
        if(isVisited.contains(node)) return true;

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        Node thisNode = node;
        while (!stack.isEmpty())
        {
            Node cur = stack.pop();
            for(Node next : cur.nexts)
            {
                if(next == thisNode) return false;
                if(!set.contains(next))
                {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    isVisited.add(next);
                    break;
                }
            }
        }
        return true;
    }


    class Node {

        public Integer id;
        public ArrayList<Node> nexts = new ArrayList<>();

        public Node(int id)
        {
            this.id = id;
        }

    }
}
