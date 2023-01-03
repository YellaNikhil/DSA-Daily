class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int n = strs.size();
        if(n==1){
            return 0;
        }
        int count =0;
        for(int col=0;col<strs[0].length();col++){
            int j = 1;
            char prev = strs[j-1][col];
            while(j < n){
                char pres = strs[j][col];
                if( pres < prev){
                    count++;
                    break;
                }
                prev = pres;
                j++;
            }
        }
        return count;
    }
};