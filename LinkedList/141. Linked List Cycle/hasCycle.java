/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 use faster and lower runner solution. (2 pointers)
 the faster one move 2 steps, and slower one move only one step.
 if there's a circle, the faster one will finally "catch" the slower one. 
 (the distance between these 2 pointers will decrease one every time.)
 
 if there's no circle, the faster runner will reach the end of linked list. (NULL)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast, slow;
        fast = head;
        slow = head;
        while(fast.next != null && fast.next.next != null){            
            fast = fast.next.next;
            slow = slow.next;            
            if(fast == slow){
                return true;
            }
        }
        return false;
        
    }
}
