/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //reverse the second half part of list
    //then, if it is Palindrome, the first half part will be the same as the second half part.
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while(slow != null){            
            if(head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev, cur, next;
        prev = null;
        cur = head;
        next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}
