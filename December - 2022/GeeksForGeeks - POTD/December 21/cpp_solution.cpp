class Solution{
    
public:
    Node* sortList(Node* head)
    {
        // Your Code Here
        Node *pos = nullptr, *neg = nullptr, *posNext = nullptr;
		while(head!=nullptr){
		    Node *nxt = head->next;
		    if(head->data >= 0){
		        if(pos==nullptr){
		            pos = head;
		        }
		        else{
		            posNext->next = head;
		        }
		        posNext = head;
		        head->next = nullptr;
		    }
		    else{
		        head->next = neg;
		        neg = head;
		    }
		    head = nxt;
		}
		if(neg!=nullptr){
		    head = neg;
		    while(neg->next!=nullptr){
		        neg = neg->next;
		    }
		    neg->next = pos;
		}
		else{
		    head = pos;
		}
		return head;
    }
};