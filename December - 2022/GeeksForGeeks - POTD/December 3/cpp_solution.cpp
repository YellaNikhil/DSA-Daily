class Solution {
public:

    int solve(int n, int k, vector<int> &stalls) {
        sort(stalls.begin(), stalls.end());
        int lowDist = 1, highDist = 1000000001;
        int maxDist = 1;
        while(lowDist <= highDist){
            int dist = lowDist + (highDist - lowDist)/2;
            int count = 1, cowPos = 0;
            for(int pos=1;pos<n;pos++){
                if(stalls[pos] - stalls[cowPos] >= dist){
                    count++;
                    cowPos = pos;
                }
            }
            if(count >=k){
                maxDist = dist;
                lowDist = dist + 1;
            }
            else{
                highDist = dist - 1;
            }
        }
        return maxDist;
    }
};