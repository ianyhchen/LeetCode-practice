class MyLinkedList {
    class Node{
        int val;
        Node prev, next;
        Node(int v){val = v;}
    }
    private Node head;
    private Node tail;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        //this.head = null;
        //this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = head;
        int count = 0;
        while(cur != null){
            if(count == index){
                break;
            }
            cur = cur.next;
            count++;
        }
        return cur == null? -1 : cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        newHead.prev = null;
        
        if(head != null) head.prev = newHead;  //Need to check if the node is not null before set prev pointer      
        head = newHead;
        
        if(tail == null){
            tail = newHead;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){  //invalid index
            return;
        }
        Node newNode = new Node(val);
        //add at head
        if(index == 0){
            addAtHead(val);
            return;
        }
        //add at middle or end
        int count = 0;
        Node cur = head;
        // stop at the node on index - 1
        while(count != index - 1){
            cur = cur.next;
            count++;
        }
        // now we found the node bofore the target position
        newNode.next = cur.next;
        newNode.prev = cur;
        if(cur.next != null)cur.next.prev = newNode;  //Need to check if the node is not null before set prev pointer
        cur.next = newNode;
        // update tail if node is appended at the end
        if(index == size){
            tail = newNode;
        }
        size++;     
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0|| size == 0||index >= size){
            return;
        }
        //delete first node
        if(index == 0){
            if(tail == head){
                tail = null;
                head = null;
            }
            else{                 
                head = head.next;
                head.prev = null;
            }
            size--;            
            return;
        }
        //delete node in the middle or end
        Node cur = head;
        int count = 0;
        // find the node on index - 1
        while(count != index -1){
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        if(cur.next != null){           //Need to check if the node is not null before set prev pointer
            cur.next.prev = cur;
        }
        
        if(index == size -1){
            tail = cur;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
