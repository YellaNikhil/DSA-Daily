class Solution {
public: 
    vector<vector<int>> result;
    void findPaths(vector<vector<int>> &graph, int x, vector<int> res){
        int n = graph.size();
        res.push_back(x);
        if(n-1 == x){
            this->result.push_back(res);
            return;
        }
        for(auto next : graph[x]){
            findPaths(graph, next, res);
        }
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<int> res;
        findPaths(graph, 0, res);
        return this->result;
    }
};