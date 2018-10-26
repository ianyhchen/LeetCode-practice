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
        //use stack to get the value from the end of linked list
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        //int carry = 0;
        ListNode node = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()){
                sum += s1.pop();
            }
            if(!s2.empty()){
                sum += s2.pop();
            }
            node.val = sum % 10;
            ListNode  head = new ListNode(sum / 10);
            head.next = node;   //set the next pointer of new head pointer to node 
            node = head;        //***set the pointer of node back to the head
            sum /= 10;            
        }        
        return node.val == 0 ? node.next : node;
    }     
        
}
