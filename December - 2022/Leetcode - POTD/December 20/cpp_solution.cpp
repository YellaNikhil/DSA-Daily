class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        queue<int> q;
        bool visited[rooms.size()];
        memset(visited, false, sizeof(visited));
        q.push(0);
        while(!q.empty()){
            int room = q.front();
            q.pop();
            visited[room] = true;
            for(auto key : rooms[room]){
                if(!visited[key]){
                    q.push(key);
                }
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
};