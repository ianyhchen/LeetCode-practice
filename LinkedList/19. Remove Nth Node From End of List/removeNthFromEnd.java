/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;        
        ListNode fast = dummy;
        ListNode slow = dummy;
        //Advance fast pointer so that the gap between fast and slow is n nodes apart
        for(int i = 0; i < n+1; i++){
            fast = fast.next;
        }
        //Move fisrt to the end, maintaining the gap
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
