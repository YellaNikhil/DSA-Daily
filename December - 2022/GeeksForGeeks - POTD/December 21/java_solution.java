class Solution
{
	Node sortList(Node head) {
		// Your code here
		Node pos = null, neg = null, posNext = null;
		while(head!=null){
		    Node nxt = head.next;
		    if(head.data >= 0){
		        if(pos==null){
		            pos = head;
		        }
		        else{
		            posNext.next = head;
		        }
		        posNext = head;
		        head.next = null;
		    }
		    else{
		        head.next = neg;
		        neg = head;
		    }
		    head = nxt;
		}
		if(neg!=null){
		    head = neg;
		    while(neg.next!=null){
		        neg = neg.next;
		    }
		    neg.next = pos;
		}
		else{
		    head = pos;
		}
		return head;
	}
}