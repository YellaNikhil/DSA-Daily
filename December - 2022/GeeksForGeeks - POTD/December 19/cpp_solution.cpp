class Solution {
  public:
    int minimumCost(vector<vector<int>>& flights, int n, int k) {
        // code here
        vector<pair<int,int>> adj[n+1];
        for(int i=0;i<flights.size();i++){
            adj[flights[i][0]].push_back({flights[i][1], flights[i][2]});
        }
        queue<int> q;
        int dist[n+1];
        memset(dist, -1, sizeof(dist));
        q.push(k);
        dist[k] = 0;
        while(!q.empty()){
            int src = q.front();
            q.pop();
            for(auto next : adj[src]){
                if(dist[next.first]==-1 || dist[src] + next.second < dist[next.first]){
                    dist[next.first] = dist[src] + next.second;
                    q.push(next.first);
                }
            }
        }
        int ans = -1;
        for(int i=1;i<=n;i++){
            if(dist[i]==-1){
                return -1;
            }
            ans = max(ans, dist[i]);
        }
        return ans;
    }
};