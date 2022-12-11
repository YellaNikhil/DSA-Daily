class Solution {
    private int maxSum = Integer.MIN_VALUE;
    int findMaxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);
        int pathSum = Math.max(Math.max(left, right) + root.val, root.val);
        this.maxSum = Math.max(Math.max(root.val + left + right, pathSum), this.maxSum);
        return pathSum;
    }
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return this.maxSum;
    }
}