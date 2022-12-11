class Solution {
public:
    int maxSum = INT_MIN;
    int findMaxSum(TreeNode *root){
        if(!root){
            return 0;
        }
        int left = findMaxSum(root->left);
        int right = findMaxSum(root->right);
        int sum = max(root->val, max(left, right) + root->val);
        this->maxSum = max(this->maxSum, max(left + right + root->val, sum));
        return sum;
    }
    int maxPathSum(TreeNode* root) {
        findMaxSum(root);
        return this->maxSum;
    }
};