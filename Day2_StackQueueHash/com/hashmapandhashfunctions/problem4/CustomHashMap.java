package com.hashmapandhashfunctions.problem4;

import java.util.LinkedList;

class HashMap<K, V> {
    // Default initial capacity and load factor threshold
    private static final int INITIAL_SIZE = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private LinkedList<Node<K, V>>[] map;
    private int size;

    // Inner class to represent key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the map with a certain size
    public HashMap() {
        map = new LinkedList[INITIAL_SIZE];
        size = 0;

        // Initialize each bucket (linked list)
        for (int i = 0; i < INITIAL_SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to map keys to indices
    private int hash(K key) {
        return Math.abs(key.hashCode()) % map.length;
    }

    // Insert key-value pair
    public void put(K key, V value) {
        if (size >= map.length * LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Check if the key already exists, and if so, update the value
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If key doesn't exist, add a new node to the bucket
        bucket.add(new Node<>(key, value));
        size++;
    }

    // Retrieve value by key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Search for the key in the bucket
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;  // Return null if key is not found
    }

    // Delete key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Iterate through the bucket and remove the key-value pair
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    // Resize the map (double the size of the array and rehash the elements)
    private void resize() {
        LinkedList<Node<K, V>>[] oldMap = map;
        map = new LinkedList[oldMap.length * 2];  // Double the size
        size = 0;

        // Rehash all elements into the new map
        for (LinkedList<Node<K, V>> bucket : oldMap) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }

    // Print the hash map for debugging purposes
    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            LinkedList<Node<K, V>> bucket = map[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node<K, V> node : bucket) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Get the current size (number of elements in the hash map)
    public int size() {
        return size;
    }

    // Check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        // Create an instance of the custom HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Insert some key-value pairs
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("cherry", 7);
        map.put("date", 2);
        map.put("elderberry", 12);

        // Retrieve and print values
        System.out.println("Value for apple: " + map.get("apple"));   // 5
        System.out.println("Value for banana: " + map.get("banana")); // 3

        // Delete a key-value pair
        map.remove("banana");

        // Try retrieving the deleted key
        System.out.println("Value for banana after removal: " + map.get("banana")); // null

        // Print the map contents
        map.printMap();

        // Checking the size of the map
        System.out.println("Current size: " + map.size()); // 4
    }
}

