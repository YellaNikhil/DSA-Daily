#define MOD 1000000007

long long numOfWays(int N, int M)
{
    // write code here
        int dirs[][2] = {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        long long ans = 0, chances = N*M - 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                long long count = 0;
                for(int k=0;k<8;k++){
                    int x = dirs[k][0] + i, y = dirs[k][1] + j;
                    if(x >= 0 && y>=0 && x < N && y < M){
                        count++;
                    }
                }
                ans += (chances - count);
                ans = ans%MOD;
            }
        }
        return ans;
}