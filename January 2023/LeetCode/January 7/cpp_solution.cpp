class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totalGas = 0, totalCost = 0, n = gas.size();
        for(int i=0;i<n;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        long long totalReserve = (long long)gas[0] - (long long)cost[0];
        int start = 0, end = (start+1)%n;
        while(true){
            while(totalReserve <= 0 && start!=end){
                totalReserve += (long long)cost[start] - (long long)gas[start];
                start = (start+1)%n;
            }
            if(start==end){
                totalReserve += (long long)gas[start] - (long long)cost[start];
                end = (start+1)%n;
            }
            while(totalReserve >= 0 && start!=end){
                totalReserve += (long long)gas[end] - (long long)cost[end];
                end = (end+1)%n;
            }
            if(start==end){
                break;
            }
        }
        return start;
    }
};