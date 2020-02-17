package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {
    private List<Node> nodes = new ArrayList<>();

    public void insert(Node node) {
        nodes.add(node);
        if (!isDataOk()) repairToUp();
    }

    public Node get() {
        Node result = nodes.get(0);

        nodes.set(0, nodes.get(nodes.size() - 1));
        nodes.remove(nodes.size() - 1);

        repairToDown();

        return result;
    }

    public void repairToDown() {
        Node currentNode = nodes.get(0);
        Node minNode = getMinChild(currentNode);

        while (minNode != null || (minNode != null && currentNode.getFrequency() > minNode.getFrequency())) {
            swapNodes(minNode, currentNode);
            minNode = getMinChild(currentNode);
        }
        nodes.forEach(node -> System.out.println(node.getFrequency()));
    }

    private Node getMinChild(Node node) {
        int index = nodes.indexOf(node);
        Node leftChild = index * 2 + 1 < nodes.size() ? nodes.get(index * 2 + 1) : null;
        Node rightChild = index * 2 + 2 < nodes.size() ? nodes.get(index * 2 + 2) : null;

        if (leftChild != null && rightChild != null) {
            return leftChild.getFrequency() < rightChild.getFrequency()? leftChild: rightChild;
        } else if (leftChild == null) {
            return rightChild;
        } else return leftChild;

    }

    private boolean isDataOk() {
        for (int i = 0; i < nodes.size(); i++) {

            Node leftChild = i*2+1 < nodes.size() ? nodes.get(i*2+1): null;
            Node rightChild = i*2+2 < nodes.size() ? nodes.get(i*2+2): null;

            if ((leftChild != null && leftChild.getFrequency() < nodes.get(i).getFrequency()) ||
                (rightChild != null && rightChild.getFrequency() < nodes.get(i).getFrequency())) {
                return false;
            }
        }

        return true;
    }

    private void repairToUp() {
        Node parentNode = nodes.get((nodes.size() - 1) / 2);
        Node newNode = nodes.get(nodes.size() - 1);
        while (parentNode.getFrequency() > newNode.getFrequency()) {
            swapNodes(parentNode, newNode);
            parentNode = nodes.get((nodes.indexOf(newNode) - 1) / 2);
        }
        nodes.forEach(node -> System.out.println(node.getFrequency()));
    }

    private void swapNodes(Node node1, Node node2) {
        Collections.swap(nodes, nodes.indexOf(node1), nodes.indexOf(node2));
    }

}
