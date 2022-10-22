package com.ar50645.unionFind;

/**
 * Union Find Data Structure with Path Compression and Rank
 * Time Complexity
 * Constructor = O(n)
 * Find =  O(1) on average
 * Union = O(1) on average
 * Connected = O(1) on average
 */
public class UnionFind {
    int[] root;
    int[] rank;
    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];

        for(int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int getRoot(int x) {
        if(x == root[x])
            return x;
        return root[x] = getRoot(root[x]);
    }

    public void union(int x, int y) {
        int rootX = getRoot(x);
        int rootY = getRoot(y);

        if(rootX != rootY ) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if(rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY]+=1;
            }
        }
    }

    private boolean isConnected(int x, int y) {
        return getRoot(x) == getRoot(y);
    }
}


