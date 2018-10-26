/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode a = l1, b = l2, cur = dummyhead;
        int carry = 0;
        while(a != null || b != null){
            int x = (a == null) ? 0 : a.val;
            int y = (b == null) ? 0 : b.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }      
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return dummyhead.next;
    }
}
