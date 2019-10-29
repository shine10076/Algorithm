package com.graph.algorithm;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/12 14:19
 */
public class DFS {

    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty())
        {
            Node cur = stack.pop();
            for(Node next:cur.nexts)
            {
                if(next == node) System.out.println("fuck");
                if(!set.contains(next)){
                    stack.push((cur));
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        zero.nexts.add(one);
        zero.nexts.add(two);
        one.nexts.add(three);
        two.nexts.add(three);
        three.nexts.add(zero);
        dfs(one);

    }
}
