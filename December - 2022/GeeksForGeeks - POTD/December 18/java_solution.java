class Solution {
    private long getMaxLCM(long N){
        long ans = N*(N-1);
        long rem = 2;
        N-=2;
        while(N>1 && rem > 0) {
            if(gcd(ans, N) == 1){
                ans *= N;
                --rem;  
            } 
            --N;
        }
        return ans;
    }
    private long gcd(long a, long b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
    public long maxGcd(int N) {
       return Math.max(getMaxLCM(N), getMaxLCM(N-1)) ;
    }
}