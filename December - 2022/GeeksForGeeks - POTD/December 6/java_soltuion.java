
class Info{
    public int row, col;
    Info(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    static int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Info> queue = new LinkedList<Info>();
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                    queue.add(new Info(i, j));
                }
                else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            Info info = queue.poll();
            for(int k=0;k<4;k++){
                int x = dx[k] + info.row, y = dy[k] + info.col;
                if(x >= 0 && y>=0 && x<n && y<m){
                    // int dist = Math.abs(i - x) + 
                    if(grid[x][y] > grid[info.row][info.col] + 1){
                        grid[x][y] = grid[info.row][info.col] + 1;
                        queue.add(new Info(x, y));
                    }
                }
            }
        }
        return grid;
    }
}