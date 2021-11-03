package com.ar50645.dataStructure.graph;

//Topological sort is only possible with DAG. undirected graph can be viewed as having cycle as it points to both sides

import java.util.Stack;

public class TopologicalSort {

    public static Stack<Node> topologicalSort(Graph graph) {
        Stack<Node> stack = new Stack<>();
        for(Node node: graph.getNodes()) {
            if(node.getState() == Node.State.UNVISITED) {
                dfsVisit(node, stack);
            }
        }
        return stack;
    }
    public static void dfsVisit(Node node, Stack<Node> stack) {

        node.setState(Node.State.VISITING);
        for(Node neighbour: node.getNeighbors()) {
            if(neighbour.getState() == Node.State.UNVISITED) {
                dfsVisit(neighbour, stack);
            }
        }
        stack.push(node);
        node.setState(Node.State.VISITED);
    }
}
