package com.ar50645.dataStructure.graph;

import java.util.HashMap;
import java.util.Map;

import static com.ar50645.dataStructure.graph.Node.State.*;


public class DFS {

    /**
     * Given a graph and a target number T, find if T exists in the graph
     */
    public static boolean dfs(Graph graph, int target) {
        for(Node node: graph.getNodes()) {
            if(node.getState() == UNVISITED && dfsVisit(node, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfsVisit(Node node, int target) {
        node.setState(Node.State.VISITING);

        if(node.getData() == target) {
            return true;
        }
        for(Node neighbour: node.getNeighbors()) {
            if(neighbour.getState() == UNVISITED && dfsVisit(neighbour, target)) {
                return true;
            }
        }
        node.setState(VISITED);
        return false;
    }

    //Given a directed graph, make a copy

    public static Node cloneGraph(Node root) {
        if(root == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node rootCopy = new Node(root.getData());
        map.put(root, rootCopy);
        dfsVisit(root, map);
        return rootCopy;
    }

    public static void dfsVisit(Node root, Map<Node, Node> map) {

        root.setState(VISITING);

        for (Node node: root.getNeighbors()) {

            map.put(node, map.getOrDefault(node, new Node(root.getData())));

            Node nodeCopy = map.get(node);
            Node rootCopy = map.get(root);

            rootCopy.addNeighbour(map.get(nodeCopy));
            if(node.getState() == UNVISITED) {
                dfsVisit(node, map);
            }
        }
        root.setState(VISITED);
    }


}
