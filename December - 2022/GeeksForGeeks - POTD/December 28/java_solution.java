class Solution {
    static int maxSum = Integer.MIN_VALUE;
    public static int findSubTreeSum(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left = findSubTreeSum(root.left);
        int right = findSubTreeSum(root.right);
        maxSum = Math.max(maxSum, Math.max(left, right));
        if(left!=Integer.MIN_VALUE){
            root.data += left;   
        }
        if(right!=Integer.MIN_VALUE){
            root.data += right;
        }
        maxSum = Math.max(maxSum, root.data);
        return root.data;
    }
    public static int findLargestSubtreeSum(Node root) {
        // code here
        maxSum = Integer.MIN_VALUE;
        findSubTreeSum(root);
        return maxSum;
    }
}
        