

//User function Template for Java
class Info{
    public int x, y, k, dist;
    Info(int x, int y, int k, int dist){
        this.x = x;
        this.y = y;
        this.k = k;
        this.dist = dist;
    }
}


class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, 1, -1};
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        boolean[][][] visited = new boolean[n][m][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(visited[i][j], false);
            }
        }
        int ans = -1;
        Queue<Info> queue = new LinkedList<Info>();
        queue.add(new Info(0,0,k,0));
	    visited[0][0][k] = true;
        while(!queue.isEmpty()){
                Info info = queue.poll();
                visited[info.x][info.y][info.k] = true;
                if(info.x==n-1 && info.y==m-1){
                    return info.dist;
                }
                for(int index=0;index<4;index++){
                    int x = dx[index] + info.x, y = info.y + dy[index];
                    if(x >=0 && y>=0 && x < n && y < m){
                        if(mat[x][y] == 0  && !visited[x][y][info.k]){
                            queue.add(new Info(x, y, info.k, info.dist+1));
			                visited[x][y][info.k] = true;
                        }
                        else if(mat[x][y]==1 && info.k > 0 && !visited[x][y][info.k-1]){
                            queue.add(new Info(x, y, info.k - 1, info.dist+1));
			                visited[x][y][info.k-1] = true;
                        }
                    }
                }
        }
        return ans;
    }
};