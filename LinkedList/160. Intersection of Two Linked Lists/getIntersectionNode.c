/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    if(headA == NULL || headB == NULL){
        return NULL;
    }
    struct ListNode *head = headA;
    while(head->next != NULL){
        head = head->next;
    }
    //combine headB after the tail of headA
    //thus, we generate a cycle and the intersetion of two list is the node where the cycle begins.
    head->next = headB;
    //store the pointer of tail 
    struct ListNode *tail = head;
    //reset the pointer back to head
    head = headA;
    
    //fast and slow, determine if there is a cycle
    headB = headA;
    while(headB->next != NULL && headB->next->next != NULL){
        headA = headA->next;
        headB = headB->next->next;
        if(headA == headB){
            break;
        }
    }
    //no cycle
    if(headA->next == NULL || headB->next == NULL || headB->next->next == NULL){
        //break the chain 
        tail->next = NULL;
        return NULL;
    }
    //has cycle
    headA = head;
    while(headA != headB){
        headA = headA->next;
        headB = headB->next;
    }
    //break the chain
    tail->next = NULL;
    return headB;
}
