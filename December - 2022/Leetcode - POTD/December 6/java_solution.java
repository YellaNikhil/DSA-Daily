class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddNext = oddHead, evenNext = evenHead;
        while(oddNext!=null && evenNext!=null){
            oddNext.next = oddNext.next.next;
            evenNext.next = evenNext.next==null ? null : evenNext.next.next;
            evenNext = evenNext.next;
            oddNext = oddNext.next == null ? oddNext : oddNext.next;
        }
        oddNext.next = evenHead;
        return oddHead;
    }
}