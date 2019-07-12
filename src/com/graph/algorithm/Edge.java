package com.graph.algorithm;

/**
 * @author shine10076
 * @date 2019/7/12 13:38
 */
public class Edge {

    /**
     * @Param weight 边的权重
     * @Param from 边的起点
     * @Param to 边的终点
     */
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from  = from;
        this.to = to;
    }
}
