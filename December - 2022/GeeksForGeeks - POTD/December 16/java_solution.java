class Solution{
    static int findByAakriti(int n ,int m, int i, int j, int[][] mat){
        int total = 0;
        if(j%2==0){
            int[][] dirs = {{-1,2}, {0,2}, {1,2}, {1,1}, {2,0}, {1,-1}, {1,-2}, {0,-2}, {-1,-2}, {-2,-1}, {-2,0}, {-2,1}};
            for(int index = 0;index < dirs.length;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        else{
            int[][] dirs = {{-1,2}, {0,2}, {1,2}, {2,1}, {2,0}, {2,-1}, {1,-2}, {0,-2}, {-1,-2}, {-1,-1}, {-2,0}, {-1,1}};
            for(int index = 0; index < dirs.length;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        return total;
    }
    static int findByAvantika(int n, int m, int i, int j, int mat[][]){
        int total = 0;
        if(j%2==0){
            int[][] dirs = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}};
            for(int index = 0;index < dirs.length;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        else{
            int[][] dirs = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}};
            for(int index = 0; index < dirs.length;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        return total;
    }
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        // code here
        int total = 0;
        if(ty==0){
            total = findByAvantika(n, m, i, j, mat);
        }
        else{
            total = findByAakriti(n, m, i, j, mat);
        }
        return total;
    }
}