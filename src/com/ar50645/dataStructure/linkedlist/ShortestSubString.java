package com.ar50645.dataStructure.linkedlist;

/*
Smallest Subarray Covering All Values: Let's say you are given a large text document Doc.
You are also given a set S of words. You want to find the smallest substring of Doc that contains all the words in S.
For example:S: ["and", "of", "one"] Doc: "a set of words that is complete in itself, typically containing a subject and predicate,
conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one
or more subordinate clauses "The underlined part above is the solution. Note that the order in which the words appear doesn't matter.
Also, the length of the substring is in terms of number of characters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ShortestSubString {

    public String getShortestSubString(String doc, HashSet<String> wordSet) {
        String result = null;

        //initialize LinkedHashmap
        HashMap<String, Node> nodeMap = new HashMap<>();
        LinkedList linkedList = new LinkedList();

        Iterator itr = new WordIterator(doc, 0);
        while (itr.hasNext()){
            WordIndex wordIndex = (WordIndex) itr.next();
            String word = wordIndex.getWord();

            if(!wordSet.contains(word)) {
                continue;
            }

            if(nodeMap.containsKey(word)) {
                Node toDelete = nodeMap.get(word);
                linkedList.delete(toDelete);
            }
            Node newNode = new Node(word, wordIndex.getIndex());
            linkedList.append(newNode);
            nodeMap.put(word, newNode);

            if(nodeMap.size() == wordSet.size()) {
                int startIndex = linkedList.getHead().getIndex();
                int endIndex = linkedList.getTail().getIndex() + linkedList.getTail().getData().length() - 1;

                if(result == null || endIndex - startIndex + 1 < result.length()) {
                    result = doc.substring(startIndex, endIndex + 1);
                }
            }
        }
        return result;
    }

    class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public void append(Node toAdd){
            if(head == null) {
                head = toAdd;
            }else {
                tail.setNext(toAdd);
                toAdd.setPrev(tail);
            }
            tail = toAdd;
        }

        public void delete(Node toDelete) {
            if(toDelete == null) {
                return;
            }
            if(toDelete.getPrev() != null) {
                toDelete.getPrev().setNext(toDelete.getNext());
            }
            if(toDelete.getNext() != null) {
                toDelete.getNext().setPrev(toDelete.getPrev());
            }
            if(toDelete == head) {
                head = toDelete.getNext();
            }
            if(toDelete == tail) {
                tail = toDelete.prev;
            }
        }
    }

    class Node {
        private String data;
        private Node prev;
        private Node next;
        private int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node(String data, int index) {
            this.data = data;
            this.prev = null;
            this.next = null;
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class WordIndex {
        String word;
        int index;

        public WordIndex(String word, int index) {
            this.word = word;
            this.index = index;
        }

        public String getWord() {
            return word;
        }

        public int getIndex() {
            return index;
        }
    }

    public class WordIterator implements Iterator<WordIndex> {
        String str;
        int position;

        public WordIterator(String str, int position) {
            this.str = str.trim();
            this.position = position;
            advanceToNextAlphabet();
        }

        //Advances position to next alphabet in str
        private void advanceToNextAlphabet() {
            while (position < str.length() && !Character.isAlphabetic(str.charAt(position))) {
                position++;
            }
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return position < str.length();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public WordIndex next() {
            if(!hasNext())
                throw new NoSuchElementException();
            int wordStartIndex = position;

            //advance position to next non alphabet
            while (position < str.length() && Character.isAlphabetic(str.charAt(position))) {
                position++;
            }

            int wordEndIndex = position - 1;

            advanceToNextAlphabet();
            return new WordIndex(str.substring(wordEndIndex, wordEndIndex + 1), wordStartIndex);
        }
    }
}
