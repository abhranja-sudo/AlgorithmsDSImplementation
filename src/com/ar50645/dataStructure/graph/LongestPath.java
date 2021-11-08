package com.ar50645.dataStructure.graph;

/* Diameter of a Graph: Given a directed graph, find the length of the longest path in the graph.
 The path can start from any node.
*/

import java.util.*;

public class LongestPath {

    //DP solution
    public static int findLenLongestPath(Graph graph) {
        if(graph.getNodes().get(0) == null)
            return 0;
        Stack<Node> sortedNode = topologicalSort(graph.getNodes().get(0));

        Map<Node, Integer> trackLongest = new HashMap<>();
        for(Node currentNode: sortedNode) {
            trackLongest.put(currentNode, -1);
        }

        trackLongest.put(sortedNode.peek(), 1);

        while (!sortedNode.isEmpty()) {
            Node currentNode = sortedNode.pop();
            for (Node neighbour: currentNode.getNeighbors()) {
                trackLongest.put(neighbour, Integer.max(trackLongest.get(neighbour), trackLongest.get(currentNode) + 1 ));
            }
        }

        return Collections
                .max(trackLongest.entrySet(), Map.Entry.comparingByValue())
                .getValue();
    }

    public static Stack<Node> topologicalSort(Node node) {
        Stack<Node> stack = new Stack<>();
        dfsVisit(node, stack);
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
