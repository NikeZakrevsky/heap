package com.company;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(new Node(4));
        heap.insert(new Node(18));
        heap.insert(new Node(7));
        heap.insert(new Node(20));
        heap.insert(new Node(21));
        heap.insert(new Node(18));
        heap.insert(new Node(42));
        heap.insert(new Node(53));
        heap.insert(new Node(22));
        heap.insert(new Node(5));

        Node node = heap.get();
        System.out.println(node);
    }
}
