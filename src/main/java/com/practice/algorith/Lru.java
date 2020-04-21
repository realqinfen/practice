package com.practice.algorith;

import java.util.*;

public class Lru {

    //LinkedHashMap
    class cache1 {
        private int capcity;
        private LinkedHashMap<Integer, Integer> cache;

        public cache1(int capcity) {
            this.capcity = capcity;
            this.cache = new LinkedHashMap<>(capcity);
        }

        private int get(int key) {
            if (!cache.containsValue(key)) {
                return -1;
            }
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }

        private void put(int key, int value) {
            if (cache.containsValue(key)) {
                cache.remove(key);
            }
            if (capcity == cache.size()) {
                Iterator<Integer> iterator = cache.keySet().iterator();
                cache.remove(iterator.next());
            }
            cache.put(key, value);
        }
    }

    class LinkedHashMapLru {
        private int capacity;
        private Map<Integer, Integer> cache;

        public LinkedHashMapLru(int capacity) {
            this.capacity = capacity;
            cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return super.removeEldestEntry(eldest);
                }
            };
        }

        public int get(int key) {
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    class cache2 {
        private int capacity;
        private Map<Integer, Integer> cache;

        public cache2(int capacity) {
            this.capacity = capacity;
            cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return super.removeEldestEntry(eldest);
                }
            };
        }

        public int get(int key) {
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    //依赖hashmap判重
    class Cache3 {
        private DoublyLinkedList cache;
        private HashMap<Integer, Node> map;
        private int capacity;

        public Cache3(int capacity) {
            this.capacity = capacity;
            this.cache = new DoublyLinkedList();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node n = map.get(key);
            cache.moveToTail(n);
            return n.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                cache.moveToTail(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                cache.addToTail(node);

                if (map.size() > capacity) {
                    Node n = cache.removeHead();
                    map.remove(n.key);
                }
            }
        }
    }

    class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void moveToTail(Node n) {
            if (n == null || n == tail) {
                return;
            } else if (n == head) {
                head = head.next;
                head.pre = null;
            } else {
                n.pre.next = n.next;
                n.next.pre = n.pre;
            }
            tail.next = n;
            n.pre = tail;
            n.next = null;
            tail = tail.next;
        }

        public void addToTail(Node n) {
            if (n == null) {
                return;
            }
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                n.pre = tail;
                n.next = null;
                tail = tail.next;
            }
        }

        private Node removeHead() {
            if (head == null) {
                return null;
            }
            Node temp = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return temp;
        }
    }

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}
