class Solution {
    private boolean checkSign(String S){
        if(S.length() > 1){
            return false;
        }
        if(S.charAt(0)=='+' || S.charAt(0)=='-' || S.charAt(0)=='/' || S.charAt(0)=='*'){
            return true;
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(checkSign(tokens[i])){
                char ch = tokens[i].charAt(0);
                int y = stack.pop();
                int x = stack.pop();
                if(ch=='+'){
                    stack.push(x + y);
                }
                else if(ch=='-'){
                    stack.push(x - y);
                }
                else if(ch=='*'){
                    stack.push(x*y);
                }
                else{
                    stack.push(x/y);
                }
            }
            else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}