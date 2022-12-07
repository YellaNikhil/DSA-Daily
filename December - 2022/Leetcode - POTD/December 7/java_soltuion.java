class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int left = 0, right = 0;
        if(root.val < low){
            left += rangeSumBST(root.right, low, high);
        }
        else if(root.val > high){
            right += rangeSumBST(root.left, low, high);
        }
        else{
            left += rangeSumBST(root.left, low, high) + root.val;
            right += rangeSumBST(root.right, low, high);
        }
        return left + right;
    }
}