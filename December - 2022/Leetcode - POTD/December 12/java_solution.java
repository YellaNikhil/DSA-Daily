class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int ans = 2, oneStep = 2, twoStep = 1;
        for(int i=3;i<=n;i++){
            ans = twoStep + oneStep;
            twoStep = oneStep;
            oneStep = ans;
        }
        return ans;
    }
}