bool compare(pair<int, char> p, pair<int, char> q){
    return p.first > q.first;
}
class Solution {
public:
    string frequencySort(string s) {
        int alphas[256];
        memset(alphas, 0, sizeof(alphas));
        for(auto ch : s){
            alphas[ch]++;
        }
        vector<pair<int,char>> freq;
        for(int i=0;i<256;i++){
            if(alphas[i] > 0){
                freq.push_back({alphas[i], (char)i});
            }
        }
        sort(freq.begin(), freq.end(), compare);
        int index = 0;
        // string result ="";
        for(auto p : freq){
            while(p.first > 0){
                p.first--;
                // result.push_back(p.second);
                s[index++] = p.second;
            }
        }
        return s;
    }
};