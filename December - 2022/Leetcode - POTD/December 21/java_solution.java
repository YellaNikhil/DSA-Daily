class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors= new int[N+1];
        for (int i=1; i<=N; i++)
            if (colors[i]==0 && (!dfs(dislikes, i, colors, 1) && !dfs(dislikes, i, colors, 2))) return false;
        return true;
    }
    public boolean dfs(int[][] dislikes, int i, int[] colors, int curColor){
        if (colors[i]!=0) return colors[i]==curColor;
        colors[i]=curColor;
        for (int[] d: dislikes)
            if (d[0]==i && !dfs(dislikes, d[1], colors, curColor^3)|| d[1]==i && !dfs(dislikes, d[0], colors, curColor^3)){
                colors[i]=0;
                return false;
            } 
        return true;
    }
}