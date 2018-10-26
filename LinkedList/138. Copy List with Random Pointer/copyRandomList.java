/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    
    //Iterative solution with O(1) space
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        // Creating a new weaved list of original and copied nodes.
        RandomListNode cur = head;
        while(cur != null){
            //clone node
            RandomListNode newNode = new RandomListNode(cur.label);
            
            //Inserting the cloned node just next to the original node
            //A->B->C => A->A'->B->B'->C->C'
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;            
        }
        
        cur = head;
        
        //Link the random pointers of the new nodes
        //Iterate the newly created list and use original nodes's random pointers,
        //to assign reference to random pointer for cloned nodes.
        while(cur != null){
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }
        
        //Unweave the linked list to get back the original list and the cloned list.
        //A -> A' -> B -> B' = > A->B->C and A'->B'->C'
        RandomListNode old_list = head;
        RandomListNode new_list = head.next;
        RandomListNode newHead = head.next;
        while(old_list != null){
            old_list.next = old_list.next.next;
            new_list.next = (new_list.next != null) ? new_list.next.next : null;
            old_list = old_list.next;
            new_list = new_list.next;
        }
        return newHead;
    }
    
    /*
    //Recursive solution
    // HashMap which holds old nodes as keys and new nodes as its values.
    Map<RandomListNode, RandomListNode> visitedMap = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        // If we have already processed the current node, then we simply return the cloned version of it.
        if(this.visitedMap.containsKey(head)){
            return this.visitedMap.get(head);
        }
        // Create a new node with the label same as old node. (i.e. copy the node)
        RandomListNode node = new RandomListNode(head.label);
        
        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them.
        this.visitedMap.put(head, node);
        
        // Recursively copy the remaining linked list starting once from the next pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }*/
}
