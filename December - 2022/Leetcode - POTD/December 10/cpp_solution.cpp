#define MOD 1000000007

class Solution {
public:
    long long int totalProduct = INT_MIN;
    long long int totalSum = 0;
    long long int findTotalSum(TreeNode *root){
        if(!root){
            return 0;
        }
        return root->val + findTotalSum(root->left) + findTotalSum(root->right);
    }
    long long int findMaxProduct(TreeNode* root){
        if(!root){
            return 0;
        }
        if(!root->left && !root->right){
            return root->val;
        }
        long long left = findMaxProduct(root->left);
        long long right = findMaxProduct(root->right);
        long long leftProduct = ((totalSum-left) * left);
        long long rightProduct = ((totalSum - right) * right);
        this->totalProduct = max(totalProduct, max(leftProduct, rightProduct));
        return left + right + root->val;
    }
    int maxProduct(TreeNode* root) {
        totalSum = findTotalSum(root);
        findMaxProduct(root);
        return totalProduct%MOD;
    }
};