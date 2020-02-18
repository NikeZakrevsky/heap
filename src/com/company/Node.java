package com.company;

public class Node {
    private long frequency;
    private char value = '0';

    public Node(long frequency) {
        this.frequency = frequency;
    }

    public long getFrequency() {
        return frequency;
    }

    public char getValue() {
        return value;
    }
}
