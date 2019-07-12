package com.graph.algorithm;

/**
 * @author shine10076
 * @date 2019/7/12 13:46
 */
public class GraphGenerator {
    /**
     *
     * @param matrix 矩阵的第一列代表边的权值，第二列代表七点，第三列代表终点
     * @return 返回Graph 对象
     */
    public static Graph createGraph(Integer[][] matrix)
    {
        Graph graph = new Graph();
        for(int i=0; i<matrix.length;i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(newEdge);

        }
        return graph;
    }
}
