class Solution{
    public:
    int findByAakriti(int n ,int m, int i, int j, vector<vector<int>> mat){
        int total = 0;
        if(j%2==0){
            int dirs[][2] = {{-1,2}, {0,2}, {1,2}, {1,1}, {2,0}, {1,-1}, {1,-2}, {0,-2}, {-1,-2}, {-2,-1}, {-2,0}, {-2,1}};
            for(int index = 0;index < 12;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        else{
            int dirs[][2] = {{-1,2}, {0,2}, {1,2}, {2,1}, {2,0}, {2,-1}, {1,-2}, {0,-2}, {-1,-2}, {-1,-1}, {-2,0}, {-1,1}};
            for(int index = 0; index < 12;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        return total;
    }
    int findByAvantika(int n, int m, int i, int j, vector<vector<int>> mat){
        int total = 0;
        if(j%2==0){
            int dirs[][2] = {{0,1}, {0,-1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}};
            for(int index = 0;index < 6;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        else{
            int dirs[][2] = {{0,1}, {0,-1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}};
            for(int index = 0; index < 6;index++){
                int x = dirs[index][0] + i, y = dirs[index][1] + j;
                if(x >= 0 && y>=0 && x < n && y < m){
                    total += mat[x][y];
                }
            }
        }
        return total;
    }
    int hopscotch(int n, int m, vector<vector<int>> mat, int ty, int i, int j)
    {
        int total = 0;
        if(ty==0){
            total = findByAvantika(n, m, i, j, mat);
        }
        else{
            total = findByAakriti(n, m, i, j, mat);
        }
        return total;
    }
};