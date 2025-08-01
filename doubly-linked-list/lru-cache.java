class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node() {}
        Node(int k, int v) { 
            key = k; value = v; 
        }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity * 2);

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            addFirst(n);
            size++;

            if (size > capacity) {
                Node lru = removeLast();
                if (lru != null) {
                    map.remove(lru.key);
                    size--;
                }
            }
        }
    }

    private void addFirst(Node node) {
        Node first = head.next;

        node.prev = head;
        node.next = first;

        head.next = node;
        first.prev = node;
    }

    private void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;

        p.next = n;
        n.prev = p;

        node.prev = node.next = null;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    private Node removeLast() {
        Node lru = tail.prev;
        if (lru == head) {
            return null;
        }
        removeNode(lru);
        return lru;
    }
}