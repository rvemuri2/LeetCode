import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache implemented with:
 *  - HashMap<K, Node> for O(1) key -> node lookup
 *  - Doubly linked list to maintain recency order in O(1)
 *      * Most-recently-used (MRU) node is right after 'head'
 *      * Least-recently-used (LRU) node is right before 'tail'
 *
 *  Operations:
 *    get(key):
 *      - If found, move the node to the front (MRU) and return value.
 *      - Else return -1.
 *
 *    put(key, value):
 *      - If key exists: update value and move to front (MRU).
 *      - Else: create a new node, add to front. If over capacity, evict LRU.
 *
 *  All operations are O(1) average time.
 */
class LRUCache {

    // Doubly linked list node
    private static class Node {
        int key, value;
        Node prev, next;
        Node() {}
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, Node> map;

    // Sentinels for the doubly linked list to avoid edge-case checks
    private final Node head; // dummy head (MRU side)
    private final Node tail; // dummy tail (LRU side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity * 2);

        // Initialize the sentinel nodes and link them
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /** Returns the value if key exists; otherwise -1. Also marks the entry as most-recently used. */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        moveToFront(node);
        return node.value;
    }

    /** Inserts or updates key with value. If capacity exceeded, evicts the least-recently used key. */
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // Update existing node and move it to front (MRU)
            node.value = value;
            moveToFront(node);
        } else {
            // Create new node
            Node n = new Node(key, value);
            map.put(key, n);
            addFirst(n);
            size++;

            // Evict if necessary
            if (size > capacity) {
                Node lru = removeLast();
                if (lru != null) {
                    map.remove(lru.key);
                    size--;
                }
            }
        }
    }

    /* ======================= Doubly Linked List Helpers ======================= */

    // Insert node right after head (mark as MRU)
    private void addFirst(Node node) {
        Node first = head.next;

        node.prev = head;
        node.next = first;

        head.next = node;
        first.prev = node;
    }

    // Remove an arbitrary node from the list
    private void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;

        p.next = n;
        n.prev = p;

        node.prev = node.next = null; // not necessary but helps avoid bugs
    }

    // Move an existing node to the front (MRU)
    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    // Remove and return the last real node (LRU). Returns null if list is empty.
    private Node removeLast() {
        Node lru = tail.prev;
        if (lru == head) return null; // list empty
        removeNode(lru);
        return lru;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */