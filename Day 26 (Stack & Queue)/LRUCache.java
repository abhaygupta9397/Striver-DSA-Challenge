class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static HashMap<Integer, Node> map;
    static Node head;
    static Node tail;
    static int capacity;

    LRUCache(int cap) {
        capacity = cap;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static void insert(Node node) {
        Node first = head.next;

        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }

    public static int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public static void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            remove(node);
            insert(node);

            return;
        }

        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insert(newNode);
        map.put(key, newNode);
    }
}
