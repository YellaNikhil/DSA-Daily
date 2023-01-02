class Solution {
    private void setMaxValue(Node root, ArrayList<Integer> result, int level){
        if(root==null){
            return ;
        }
        if(result.size() <= level){
            result.add(root.data);
        }
        else{
            int val = Math.max(result.get(level), root.data);
            result.set(level, val);
        }
        setMaxValue(root.left, result, level + 1);
        setMaxValue(root.right, result, level + 1);
    }
    ArrayList<Integer> maximumValue(Node root) {
       //code here
       ArrayList<Integer> result = new ArrayList<Integer>();
       setMaxValue(root, result, 0);
       return result;
    }
}