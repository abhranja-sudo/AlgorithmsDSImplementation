package com.ar50645.dataStructure.graph;

import java.util.*;

public class BFS {

    //Given a graph and a target number T, find T exists in the graph.
    public boolean bfsFind(Node root, int target) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.setState(Node.State.VISITING);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if(current.getData() == target) {
                return true;
            }
            for(Node neighbour : current.getNeighbors()) {
                if(neighbour.getState() == Node.State.UNVISITED) {
                    queue.add(neighbour);
                    neighbour.setState(Node.State.VISITING);
                }
            }
            current.setState(Node.State.VISITED);
        }
        return false;
    }

    //Print Graph in Level Order: Given a graph and a nodeN, print the Graph in order of distance from N.
    // Each level should be in a new line.

    public void bfsPrint(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //marker node
        Node markerNode = new Node(-1);
        queue.add(markerNode);
        root.setState(Node.State.VISITING);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if(current == markerNode) {
                if(!queue.isEmpty()){
                    queue.add(markerNode);
                }
                System.out.print("\n");
                continue;
            }
            System.out.print(current.getData() + " ");

            for(Node neighbours: root.getNeighbors()) {
                if(neighbours.getState() == Node.State.UNVISITED) {
                    queue.add(neighbours);
                    neighbours.setState(Node.State.VISITING);
                }
            }
            current.setState(Node.State.VISITED);
        }
    }


    /*
    Word Ladder
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
    beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
     sequence from beginWord to endWord, or 0 if no such sequence exists.
     */

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);

        int height = 0;
        HashSet<String> set = new HashSet<>();
        set.add(beginWord);


        while (!queue.isEmpty()) {
            String currentWord = queue.remove();
            if(queue.isEmpty()) {
                break;
            }
            if(currentWord == null) {
                height++;
                queue.add(null);
                continue;
            }
            if(currentWord.equals(endWord)) {
                return height + 1;
            }
            for(String neighbour: getNearestWord(currentWord, wordList)) {
                if(!set.contains(neighbour)) {
                    set.add(neighbour);
                    queue.add(neighbour);
                }

            }

        }
        return 0;
    }

    public static List<String> getNearestWord(String word, List<String> wordList) {
        List<String> result = new ArrayList<>();
        char[] charArray = word.toCharArray();

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            for(char c = 'a'; c <= 'z'; c++) {
                if(currentChar != c) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if(wordList.contains(newWord)){
                        result.add(newWord);
                    }
                }
            }
            charArray[i] = currentChar;
        }

        return result;
    }

}
