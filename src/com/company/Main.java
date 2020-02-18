package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Heap heap = new Heap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        for (long i = 0; i < n; i++) {
            String[] command = reader.readLine().split(" ");
            if (command[0].equals("Insert")) heap.insert(new Node(Long.parseLong(command[1])));
            if (command[0].equals("ExtractMax")) System.out.println(heap.get().getFrequency());
        }
    }
}
