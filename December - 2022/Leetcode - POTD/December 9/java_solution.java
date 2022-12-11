class Solution {
    private int DFS(TreeNode node, int max, int min){
    if(node == null)
        return 0;
    max = Math.max(max, node.val);
    min = Math.min(min, node.val);
    return node.left == node.right ? max - min : Math.max(DFS(node.left, max, min), DFS(node.right, max, min));
}
    public int maxAncestorDiff(TreeNode root) {
        return DFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
