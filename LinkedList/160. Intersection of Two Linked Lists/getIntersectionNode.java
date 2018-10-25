/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        //retrieve the tail and size of two list
        Result resultA = getTailandSize(headA);
        Result resultB = getTailandSize(headB);
        //No intersection if tails are not the same
        if(resultA.tail != resultB.tail){
            return null;
        }
        ListNode shorter = resultA.size < resultB.size ? headA : headB;
        ListNode longer = resultA.size < resultB.size ? headB : headA;
        //the longer list step forward the length difference
        int k = Math.abs(resultA.size - resultB.size);
        while(k > 0 && longer != null){
            longer = longer.next;
            k--;
        }
        //search the intersection point 
        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;        
    }
    class Result{
        public ListNode tail;
        public int size;
        public Result(ListNode tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }
    Result getTailandSize(ListNode list){
        if(list == null){
            return null;
        }
        int size = 1;
        ListNode cur = list;
        while(cur.next != null){
            size++;
            cur = cur.next;            
        }
        return new Result(cur, size);
    }
}
