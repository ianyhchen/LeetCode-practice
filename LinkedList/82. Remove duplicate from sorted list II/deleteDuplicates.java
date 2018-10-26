/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow:track the node before the dup nodes, 
	    // fast: find the last node of dups.
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);        
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        //slow.next = fast;
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;   //find the last duplicate node
            }
            if(slow.next != fast){      //duplicate detected
                slow.next = fast.next;  //remove duplicates
                fast = fast.next;       //reposition the fast pointer.
            }
            else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
