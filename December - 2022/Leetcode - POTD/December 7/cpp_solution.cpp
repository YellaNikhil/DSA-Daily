class Solution {
public:
    // int sum = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(root==nullptr){
            return 0;
        }
        int left = 0, right = 0;
        if(root->val < low){
            left += rangeSumBST(root->right, low, high);
        }
        else if(root->val > high){
            right += rangeSumBST(root->left, low, high);
        }
        else{
            left += root->val + rangeSumBST(root->left, low, high);
            right += rangeSumBST(root->right, low, high);
        }
        return left + right;
    }
};