class Solution
{
    public int count = 0;
    private boolean findSingleValues(Node root, int parent){
        if(root==null){
            return true;
        }
        if(root.left ==null && root.right==null){
            count++;
            return parent==root.data;
        }
        boolean left = findSingleValues(root.left, root.data);
        boolean right = findSingleValues(root.right, root.data);
        if(left && right){
            count++;
        }
        return left && right && parent==root.data;
    }
    public int singlevalued(Node root)
    {
        //code here
        if(root==null){
            return 0;
        }
        findSingleValues(root, root.data);
        return this.count;
    }
}