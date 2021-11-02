package com.ar50645.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> neighbors;
    private int data;
    private State state;

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbour(Node node) {
        neighbors.add(node);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node(int data) {
        this.data = data;
        state = State.UNVISITED;
        neighbors = new ArrayList<>();
    }

    public enum State {
        UNVISITED,
        VISITING,
        VISITED;
    }
}
