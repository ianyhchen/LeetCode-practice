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

/*
return the node where the cycle begins

        n6-----------n5
        |            |
  n1--- n2---n3--- n4|
  if n1->n2 = a,n2->n5 = b, n5->n2 = c, when met at n5, fast will move a+b+c+b steps, and slow will move a+b steps
  a+b+c+b = 2*(a+b) --> a = c
  set one pointer at head and another pointer at n5, move one step per move, and two ponters will finally met at n2.
  

*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //find the position they meet
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //set slow pointer to head, they both far from the begin point k steps away
        //step forward with the same speed, they will meet in the begin point
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
