/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {        
        ListNode mergehead = new ListNode(0);   //set a dummy head
        ListNode merge = mergehead;             //point merge to dummy head
        while(l1 != null || l2 != null){        //traverse two list, add the smaller node into merge
            if(l1 == null){                     //if one list is traverse to the end, set the next pointer to another list
                merge.next = l2;
                break;                
            }
            if(l2 == null){
                merge.next = l1;
                break;
            }            
            if(l1.val <= l2.val){
               merge.next = l1;
               merge = merge.next;
               l1 = l1.next;
            }
            else{
                merge.next = l2;
                merge = merge.next;
                l2 = l2.next;
            }
        }        
        return mergehead.next;
    }     
}
