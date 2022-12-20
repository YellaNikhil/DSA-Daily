class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<int> adj[n];
        for(int i=0;i<edges.size();i++){
            adj[edges[i][0]].emplace_back(edges[i][1]);
            adj[edges[i][1]].emplace_back(edges[i][0]);
        }
        queue<int> q;
        q.push(source);
        vector<bool> visited(n, false);
        while(!q.empty()){
            source = q.front();
            q.pop();
            if(source==destination){
                return true;
            }
            visited[source] = true;
            for(auto next : adj[source]){
                if(!visited[next]){
                    q.push(next);
                }
            }
        }
        return false;
    }
};