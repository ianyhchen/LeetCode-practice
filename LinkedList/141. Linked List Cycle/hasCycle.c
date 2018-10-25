/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


bool hasCycle(struct ListNode *head) {
    struct ListNode *fast, *slow;
    fast = head;
    slow = head;
    if(head==NULL||head->next == NULL){
        return false;
    }
    //use fast and slow pointer to determine if it has a cycle
    //fast moves forward 2 nodes, slow moves 1 node per round.
    while(fast&&slow){        
        if(fast->next == NULL){
            return false;
        }
        else{
            fast = fast->next->next;
            slow = slow->next;
        }
        //cycle
        if(fast == slow){
            return true;
        }        
    }
    return false;
}
