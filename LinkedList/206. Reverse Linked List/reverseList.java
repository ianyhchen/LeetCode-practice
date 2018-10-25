/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*Iterative solution*/
    public ListNode reverseList(ListNode head) {        
        ListNode prev, cur, next;
        prev = null;
        cur = head;
        next = null;
        while(cur != null){
            //Before changing next of current, store next node
            next = cur.next;
            // Now change next of current
            // This is where actual reversing happens
            cur.next = prev;
            prev = cur;
            //Move prev and curr one step forward
            cur = next;
        }
        head = prev;
        return head;
    }
    /*recursive solution*/
    /*public ListNode reverseList(ListNode head) {    
        return reverseList_recursive(head, null);
    }
    private ListNode reverseList_recursive(ListNode head, ListNode newhead){
        if(head == null){
            return newhead;
        }
        ListNode next = head.next;
        head.next = newhead;
        return reverseList_recursive(next, head);
    }*/
}
