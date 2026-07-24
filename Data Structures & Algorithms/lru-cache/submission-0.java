class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key=key;
        this.val=value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    private int cap;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap=capacity;
        this.head=new Node(0,0);
        this.tail= new Node(0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));

            return map.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newNode = new Node(key,value);
        insert(newNode);
        map.put(key, newNode);

        if(map.size()>cap){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
    }
}
