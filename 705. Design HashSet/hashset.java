class MyHashSet {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    private Node[] nodes;
    private int length;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        length = 10000;
        nodes = new Node[length];
        for(int i = 0; i < length; i++){
            nodes[i] = new Node(-1);
        }
        
    }
    
    public void add(int key) {
        int index = key % length;
        Node current = nodes[index];
        if(current == null){
            nodes[index] = new Node(key);
        }
        else{
            while(current.next != null && current.next.val != key){
                current = current.next;
            }
            if(current.next != null){//?
                return;
            }
            current.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int index = key % length;
        Node current = nodes[index];
        while(current.next != null && current.next.val != key){
            current = current.next;
        }
        if(current.next != null){
            current.next = current.next.next; 
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % length;
        Node current = nodes[index];
        while(current.next != null && current.next.val != key){
            current = current.next;
        }
        return current.next != null;
    }
    
    /*public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(3);
        obj.add(4);
        obj.remove(3);
        obj.contains(4);
    }*/
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

