class Solution{
    public int changeSumTree(Node root){
        if(root==null){
            return 0;
        }
        int val = root.data, left = 0, right = 0;
        root.data = 0;
        if(root.left!=null){
            root.data += changeSumTree(root.left);
            root.data += root.left.data;
        }
        if(root.right!=null){
            root.data += changeSumTree(root.right);
            root.data += root.right.data;
        }
        return val;
    }
    public void toSumTree(Node root){
         //add code here.
        changeSumTree(root);
    }
}