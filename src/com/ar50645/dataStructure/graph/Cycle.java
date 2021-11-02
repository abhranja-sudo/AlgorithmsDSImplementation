package com.ar50645.dataStructure.graph;

public class Cycle {

    //Given a graph, find if there is a cycle. Can find with DFS

    public static boolean hasCycle(Graph graph) {
        for(Node node: graph.getNodes()) {
            if(node.getState() == Node.State.UNVISITED) {
                if(hasCycleDfsVisit(node)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasCycleDfsVisit(Node node) {

        node.setState(Node.State.VISITING);

        for(Node neighbour: node.getNeighbors()) {
            if(neighbour.getState() == Node.State.VISITING) {
                return true;
            } else if(neighbour.getState() == Node.State.UNVISITED && hasCycleDfsVisit(neighbour)){
                return true;
            }
        }
        node.setState(Node.State.VISITED);
        return false;
    }
}
