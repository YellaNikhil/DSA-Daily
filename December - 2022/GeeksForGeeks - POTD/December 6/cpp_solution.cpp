class Node{
    public:
    int row;
    int col;
    int dist;
    Node(int r,int c,int dist){
        this->row = r;
        this->col = c;
        this->dist = dist;
    }
};

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

class Solution 
{
    public:
    //Function to find distance of nearest 1 in the grid for each cell.
    bool checkPoints(int i,int j, int n, int m){
        if(i >=0 && j>=0 && i < n && j<m){
            return true;
        }
        return false;
    }
	vector<vector<int>> nearest(vector<vector<int>> grid)
	{
	    // Code here
	    int n = grid.size(), m = grid[0].size();
	   // vector<vector<int>> result(n,vector<int>(m,INT_MAX));
	    vector<Node> points;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(grid[i][j] == 1){
	               // result[i][j] = 0;
	                points.emplace_back(Node(i,j,0));
	                grid[i][j] = 0;
	            }
	            else{
	                grid[i][j] = INT_MAX;
	            }
	        }
	    }
	    for(int i=0;i<points.size();i++){
	        queue<Node> q;
	        q.push(points[i]);
	        while(q.empty()==false){
	            Node p = q.front();
	            q.pop();
	            for(int i=0;i<4;i++){
	                int x = dx[i] + p.row, y = dy[i] + p.col;
	                if(checkPoints(x,y,n,m) && grid[x][y]!=0){
	                    if(grid[x][y] > 1 + grid[p.row][p.col]){
	                        grid[x][y] = 1 + grid[p.row][p.col];
	                        q.push(Node(x,y,grid[x][y]));
	                    }
	                }
	            }
	        }
	    }
	    return grid;
	}
};
