//User function Template for C++

class Info{
    public:
    int row, col, dist, changes;
    Info(int row, int col, int dist, int changes){
        this->row = row;
        this->col = col;
        this->dist = dist;
        this->changes = changes;
    }
};
int dx[] = {-1, 1, 0, 0};
int dy[] = {0,0,1,-1};

class Solution {
  public:
    int shotestPath(vector<vector<int>> mat, int n, int m, int k) {
        // code here
        queue<Info> q;
        bool visited[n][m][k+1];
        memset(visited, false, sizeof(visited));
        q.push(Info(0,0,0,k));
        visited[0][0][k] = true;
        while(!q.empty()){
            Info info = q.front();
            q.pop();
            if(info.row==n-1 && info.col==m-1){
                return info.dist;
            }
            for(int i=0;i<4;i++){
                int row = info.row+dx[i], col = info.col + dy[i];
                if(row >=0 && col>=0 && row<n && col<m){
                    if(mat[row][col]==0 && !visited[row][col][info.changes]){
                        visited[row][col][info.changes] = true;
                        q.push(Info(row,col,info.dist+1, info.changes));
                    }
                    else if(mat[row][col]==1 && info.changes > 0 && !visited[row][col][info.changes-1]){
                        visited[row][col][info.changes-1] = true;
                        q.push(Info(row, col, info.dist + 1, info.changes - 1));
                    }
                }
            }
        }
        return -1;
    }
};