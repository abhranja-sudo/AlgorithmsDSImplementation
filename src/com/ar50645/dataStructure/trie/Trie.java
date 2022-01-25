package com.ar50645.dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a dictionary
 */
public class Trie {
     Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        char[] ch = word.toCharArray();
        Node current = root;
        for(int i = 0; i < ch.length; i++) {
            if(!current.contains(ch[i])) {
                current.addNode(ch[i]);
            }
            current = current.getNode(ch[i]);
        }

        current.setIsWord(true);
    }

    public boolean hasWord(String word) {

        char[] ch = word.toCharArray();
        Node current = root;

        for(int i = 0; i < word.length(); i++) {
            if(!current.contains(ch[i]))
                return false;
            current = current.getNode(ch[i]);
        }
        return current.isWord();
    }


    class Node {
        private HashMap<Character, Node> map;
        private boolean isWord;

        public Node() {
            this.map = new HashMap<>();
            this.isWord = false;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setIsWord(boolean word) {
            isWord = word;
        }

        public boolean contains(char ch) {
            return map.containsKey(ch);
        }

        public void addNode(char ch) {
            if(!map.containsKey(ch))
                map.put(ch, new Node());
        }

        public Node getNode(char ch) {
            return map.get(ch);
        }
    }
}
