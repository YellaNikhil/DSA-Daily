class Solution {
  public:
    // Function to find largest subtree sum.
    int findSum(Node *root, int &maxSum){
        if(root==nullptr){
            return INT_MIN;
        }
        int left = findSum(root->left, maxSum);
        int right = findSum(root->right, maxSum);
        if(left!=INT_MIN){
            root->data += left;
        }
        if(right!=INT_MIN){
            root->data += right;
        }
        maxSum = max(maxSum, root->data);
        return root->data;
    }
    int findLargestSubtreeSum(Node* root)
    {
        //Write your code here
        int maxSum = INT_MIN;
        findSum(root, maxSum);
        return maxSum;
    }
};