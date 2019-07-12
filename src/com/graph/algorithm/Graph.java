package com.graph.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shine10076
 * @date 2019/7/12 13:42
 */
public class Graph {

    /**
     * @Param nodes 图中节点的集合
     * @Param edges 图中边的结合
     */
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
