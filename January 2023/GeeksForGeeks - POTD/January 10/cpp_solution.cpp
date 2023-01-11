class Solution {
  public:
  
    int changeSumTree(Node *root){
        if(root==nullptr){
             return 0;
         }
         int val = root->data;
         root->data = 0;
         if(root->left){
             root->data += changeSumTree(root->left);
             root->data += root->left->data;
         }
         if(root->right){
             root->data += changeSumTree(root->right);
             root->data += root->right->data;
         }
         return val;
    }
    void toSumTree(Node *root){
         //add code here.
         changeSumTree(root);
    }
};