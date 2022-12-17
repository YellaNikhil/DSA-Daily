class Solution{
    final int MOD = 1000000007;
    int waysToBreakNumber(int N){
        // code here
        long ans = (long)N*3;
        ans += (((long)N - 1)*((long)N-2))/2;
        ans = ans%MOD;
        return (int)ans;
    }
}