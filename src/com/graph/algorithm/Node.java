package com.graph.algorithm;

import java.util.ArrayList;

/**
 * @author shine10076
 * @date 2019/7/12 13:32
 */
public class Node {


    public int value;
    /**
     * @Param in 图节点的入度
     * @Param out 图节点的出度
     */
    public int in;
    public int out;

    /**
     * @Param nexts 图节点的指向的节点集合
     * @Param edges 以此图节点为起点的集合
     */
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value)
    {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
