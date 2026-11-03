class LRUCache {
    int capacity;
    Map<Integer, Node> mp;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next=tail;
        tail.prev= head;
        mp = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val=value;
            remove(node);
            add(node);
        }else{
            if(mp.size()==capacity){
                mp.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key,value);
            mp.put(key,node);
            add(node);
        }
        
    }

    private void add(Node node){
        Node headNext = head.next;
        node.next=headNext;
        node.prev=head;
        head.next=node;
        headNext.prev=node;
    }

    private void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
