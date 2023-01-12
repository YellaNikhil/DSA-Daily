class Solution {
public:
    void findTime(vector<int> adj[], vector<bool> &hasApple, pair<int, bool> &info, int node, vector<bool> visited){
        visited[node] = true;
        info.second = hasApple[node];
        for(auto next : adj[node]){
            if(!visited[next]){
                pair<int, bool> left(0, false);
                findTime(adj, hasApple, left, next, visited);
                if(left.second){
                    info.second = true;
                    info.first += left.first + 1;
                }
            }
        }
    }
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        vector<int> adj[n];
        for(int i=0;i<edges.size();i++){
            adj[edges[i][0]].emplace_back(edges[i][1]);
            adj[edges[i][1]].emplace_back(edges[i][0]);
        }
        pair<int, bool> info(0, false);
        vector<bool> visited(n, false);
        findTime(adj, hasApple, info, 0, visited);
        return 2*info.first;
    }
};