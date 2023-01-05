class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int,int> m;
        for(int i=0;i<tasks.size();i++){
            m[tasks[i]]++;
        }
        int count = 0;
        for(auto it : m){
            if(it.second==1){
                return -1;
            }
            count += it.second/3;
            if(it.second%3!=0){
                count++;
            }
        }
        return count;
    }
};