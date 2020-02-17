package com.company;

public class Node {
    private int frequency;
    private char value = '0';

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getValue() {
        return value;
    }
}
