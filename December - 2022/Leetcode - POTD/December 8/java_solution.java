class Solution {
    private void findLeaves(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        findLeaves(root.left, list);
        findLeaves(root.right, list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>(); 
        findLeaves(root1, leaf1);
        findLeaves(root2, leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        for(int i=0;i<leaf1.size();i++){
            if(leaf1.get(i)!=leaf2.get(i)){
                return false;
            }
        }
        return true;
    }
}