class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node,Node> map = new LinkedHashMap<>();
        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            map.put(temp,node);
            temp = temp.next;
        }

        for(Node original : map.keySet()){
            Node newNode = map.get(original);
            newNode.next = map.get(original.next);
            newNode.random = map.get(original.random);
        }
        return map.get(head);
    }
}