class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(!head || head->next==nullptr){
            return head;
        }
        ListNode *oddHead = head, *evenHead = head->next;
        ListNode *oddNext = oddHead, *evenNext = evenHead;
        while(oddNext && evenNext){
            oddNext->next = oddNext->next->next;
            evenNext->next = evenNext->next ? evenNext->next->next : nullptr;
            oddNext = oddNext->next ? oddNext->next : oddNext;
            evenNext = evenNext->next;
        }
        oddNext->next = evenHead;
        return oddHead;
    }
};