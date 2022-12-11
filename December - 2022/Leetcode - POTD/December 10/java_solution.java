class Solution {
    final int MOD = 1000000007;
    long totalProduct = Integer.MIN_VALUE;
    long totalSum = 0;
    long findTotalSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val + findTotalSum(root.left) + findTotalSum(root.right);
    }
    private long findMaxProduct(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        long left = findMaxProduct(root.left);
        long right = findMaxProduct(root.right);
        long leftProduct = ((totalSum-left) * left);
        long rightProduct = ((totalSum - right) * right);
        this.totalProduct = Math.max(totalProduct, Math.max(leftProduct, rightProduct));
        return left + right + root.val;
    }
    public int maxProduct(TreeNode root) {
        this.totalSum = findTotalSum(root);
        findMaxProduct(root);
        return (int)(totalProduct%MOD);
    }
}