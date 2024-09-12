package com.ar50645.dataStructure.binaryTree;

import java.util.Objects;

public record Node(Node left, Node right, int value, boolean isVisited){}