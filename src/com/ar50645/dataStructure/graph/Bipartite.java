package com.ar50645.dataStructure.graph;

import com.ar50645.common.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bipartite graph usually applied in undirected graph
 * Given a graph,separate nodes into 2 groups, such that no 2 nodes in the same group have an edge
 *
 * Alternate phrasing 1:
 * 2 Color Problem: Given a graph, color its nodes with 2 colors - red and blue - such that no 2 neighbors have the same color
 *
 * Alternate phrasing 2:
 * Let's say you have invited a group of people to your house for a party. You make a graph where a node is a person
 * and an edge between 2 people means that they know each other.You want to separate them into 2 groups such that in each group,
 * no one knows each other. Determine if such a grouping is possible, and if so, make the 2 groups
 */
public class Bipartite {
    public static Pair<List<Node>, Number> bipartite(Graph graph){

        List<Node> group1 = new ArrayList<>();
        List<Node> group2 = new ArrayList<>();

        for(Node node: graph.nodes) {
            if(node.getState() == State.UNVISITED) {
                Pair<List<Node>, Number> pair = getBipartite(node);

                //If any component is not bipartite, the whole graph is not bipartite
                if(pair == null) {
                    return null;
                }
                group1.addAll(pair.first());
                group2.addAll(pair.second());
            }
        }

        return new Pair<>(group1, group2);
    }

    public static Pair<List<Node>, Number> getBipartite(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> oddNodes = new ArrayList<>();
        List<Node> evenNodes = new ArrayList<>();

        queue.add(node);
        node.state = State.VISITING;
        node.level = 0;

        while (!queue.isEmpty()) {
            Node current = queue.peek();

            //process current Node
            if(current.getLevel() % 2 == 0)
                evenNodes.add(current);
            else
                oddNodes.add(current);

            for(Node neighbour: current.getNeighbours()) {

                if(neighbour.getState() == State.UNVISITED) {
                    neighbour.setState(State.VISITING);
                    neighbour.setLevel(node.level + 1);
                    queue.add(neighbour);
                }
                else if(neighbour.getLevel() == current.getLevel()) {
                    //Odd cycle found
                    return null;
                }
            }
            current.setState(State.VISITED);
        }

        return new Pair<>(oddNodes, evenNodes);
    }

    private static class Graph {
        List<Node> nodes;
    }

    private static class Node {
        private int data;
        private List<Node> neighbours;
        private int level;
        private State state;

        public Node(int data) {
            this.data = data;
            neighbours = new ArrayList<>();
            level = -1;
            state = State.UNVISITED;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }
    }

    private enum State {
        UNVISITED,
        VISITING,
        VISITED
    }
}

