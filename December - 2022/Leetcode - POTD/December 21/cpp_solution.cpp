class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        int colors[n+1];
        memset(colors, 0, sizeof(colors));
        for(int i=1;i<=n;i++){
            if(colors[i]==0 & (!dfs(dislikes, i, colors, 1) && !dfs(dislikes, i, colors, 2))){
                return false;
            }
        }
        return true;
    }
    bool dfs(vector<vector<int>> &dislikes, int i, int colors[], int curColor){
        if (colors[i]!=0) return colors[i]==curColor;
        colors[i]=curColor;
        for (auto d : dislikes)
            if (d[0]==i && !dfs(dislikes, d[1], colors, curColor^3)|| d[1]==i && !dfs(dislikes, d[0], colors, curColor^3)){
                colors[i]=0;
                return false;
            } 
        return true;
    }
};