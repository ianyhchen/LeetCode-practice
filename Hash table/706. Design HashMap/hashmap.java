class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] nodes;
    private int length;
    /** Initialize your data structure here. */
    public MyHashMap() {
        length = 10000;
        nodes = new Node[length];
        for(int i = 0;i < length; i++){
            nodes[i] = new Node(-1,-1);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % length;
        Node cur = nodes[index];
        if(cur == null){
            nodes[index] = new Node(key,value);
        }
        else{
            while(cur.next != null && cur.next.key != key){
                cur = cur.next;
            }
            if(cur.next != null){ //update value
                cur.next.val = value;
                return;
            }
            cur.next = new Node(key,value);            
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % length;
        Node cur = nodes[index];
        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }
        if(cur.next != null){ //Returns the value to which the specified key is mapped
            return cur.next.val;
        }
        else{
            return -1;
        }
         
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % length;
        Node cur = nodes[index];
        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }
        if(cur.next != null){
            cur.next = cur.next.next;
        }        
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
