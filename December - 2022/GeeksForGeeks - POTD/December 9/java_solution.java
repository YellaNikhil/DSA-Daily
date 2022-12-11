

class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    final static long MOD = 1000000007;
    static long numOfWays(int N, int M)
    {
        // add your code here
        int[][] dirs = new int[][]{{1,2}, {2,1}, {2,-1}, {1,-2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        long ans = 0, chances = N*M - 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                long count = 0;
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
}