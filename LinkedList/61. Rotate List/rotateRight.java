/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            len++;               //get the length
        }
        tail.next = head;       // circle the link        
        int count = len -(k % len);        
        while(count > 1){       //find the new tail node
            head = head.next;            
            count--;
        }
        ListNode new_head = head.next;        
        head.next = null;    //cut off the link   
        return new_head;        
    } 
    
}
