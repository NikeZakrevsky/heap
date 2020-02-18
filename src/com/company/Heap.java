package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {
    private List<Node> nodes;

    public Heap() {
        this.nodes = new ArrayList<>();
    }

    public void insert(Node node) {
        nodes.add(node);
        siftUp();
    }

    public Node get() {
        if (nodes.size() == 0) throw new IllegalStateException("Heap is empty");
        if (nodes.size() == 1) return nodes.remove(0);

        Node result = nodes.get(0);
        Node lastInserted = nodes.remove(nodes.size() - 1);
        nodes.set(0, lastInserted);

        siftDown();

        return result;
    }

    private void siftDown() {
        int currentNode = 0;
        int maxNode = getMaxChild(currentNode);

        while (maxNode != -1 && nodes.get(currentNode).getFrequency() < nodes.get(maxNode).getFrequency()) {
            swapNodes(maxNode, currentNode);
            currentNode = maxNode;
            maxNode = getMaxChild(currentNode);
        }
    }

    private int getMaxChild(int index) {
        int leftChild = index * 2 + 1 < nodes.size() ? index * 2 + 1 : -1;
        int rightChild = index * 2 + 2 < nodes.size() ? index * 2 + 2 : -1;

        if (leftChild != -1 && rightChild != -1) {
            return nodes.get(leftChild).getFrequency() > nodes.get(rightChild).getFrequency() ? leftChild : rightChild;
        } else if (leftChild == -1) {
            return rightChild;
        } else return leftChild;

    }

    private void siftUp() {
        int newNodeIndex = nodes.size() - 1;
        int parentNodeIndex = (newNodeIndex - 1) / 2;
        while (parentNodeIndex != newNodeIndex && nodes.get(parentNodeIndex).getFrequency() < nodes.get(newNodeIndex).getFrequency()) {
            swapNodes(parentNodeIndex, newNodeIndex);
            newNodeIndex = parentNodeIndex;
            parentNodeIndex = (newNodeIndex - 1) / 2;
        }

    }

    private void swapNodes(int node1, int node2) {
        Node temp = nodes.get(node2);
        nodes.set(node2, nodes.get(node1));
        nodes.set(node1, temp);
    }
}
