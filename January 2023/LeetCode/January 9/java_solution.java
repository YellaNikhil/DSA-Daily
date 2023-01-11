class Solution {
    public static void preorder(TreeNode root, List<Integer> result){
        if(root!=null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }
}