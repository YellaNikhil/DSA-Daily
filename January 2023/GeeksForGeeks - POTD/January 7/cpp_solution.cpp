class Solution {
public:
    Node *flattenNode(Node *left, Node *right){
        if(right==nullptr){
            return left;
        }
        if(left==nullptr){
            return right;
        }
        if(left->data <= right->data){
            left->bottom = flattenNode(left->bottom, right);
            left->next = nullptr;
            return left;
        }
        right->bottom = flattenNode(left, right->bottom);
        right->next = nullptr;
        return right;
    }
    Node *flatten(Node *root){
        // Your code here
        if(root==nullptr || root->next==nullptr){
            return root;
        }
        return flattenNode(root, flatten(root->next));
    }
};