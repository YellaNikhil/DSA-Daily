class Solution {
    // Return the Kth smallest element in the given BST
public:
    int steps = 0;
    int kthSmallest(Node *root){
        if(root==nullptr){
            return -1;
        }
        int left = kthSmallest(root->left);
        if(left!=-1){
            return left;
        }
        this->steps--;
        if(this->steps==0){
            return root->data;
        }
        int right = kthSmallest(root->right);
        return right;
    }
    int KthSmallestElement(Node *root, int K) {
        // Write your code here
        this->steps = K;
        return kthSmallest(root);
    }
};