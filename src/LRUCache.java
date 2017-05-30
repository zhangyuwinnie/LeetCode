import java.util.HashMap;

public class LRUCache {
    public class Node{
        int key, value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    
    
    

    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // append the key value pair to tail
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        append_to_tail(current);
        // System.out.println("map" + " "+ map.size());
        return map.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void put(int key, int value) {
        // write your code here
        if (get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        // insert
        if (map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        append_to_tail(insert);
        
    }
    public void append_to_tail(Node current){
        tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
        
    }
  
}