import java.util.HashMap;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private int capacity;
    private int minFreq;

    private HashMap<Integer, Node> cache;
    private HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {

        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqMap.getOrDefault(node.freq, new DoublyLinkedList());

        newList.addFirst(node);

        freqMap.put(node.freq, newList);
    }

    public int get(int key) {

        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);

        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {

            Node node = cache.get(key);
            node.value = value;

            updateFreq(node);
            return;
        }

        if (cache.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node node = list.removeLast();

            cache.remove(node.key);
        }

        Node node = new Node(key, value);

        minFreq = 1;

        DoublyLinkedList list =
                freqMap.getOrDefault(1, new DoublyLinkedList());

        list.addFirst(node);

        freqMap.put(1, list);

        cache.put(key, node);
    }
}