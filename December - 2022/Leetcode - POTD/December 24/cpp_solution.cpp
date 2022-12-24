#define MOD 1000000007
class Solution {
public:
    int numTilings(int n) {
        if(n==1){
            return 1;
        }
        long long dp[n+1];
        memset(dp, 0, sizeof(dp));
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]*2 + dp[i-3])%MOD;
        }
        return dp[n];
    }
};