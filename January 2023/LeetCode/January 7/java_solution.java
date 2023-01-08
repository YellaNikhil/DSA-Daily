class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, n = gas.length;
        for(int i=0;i<n;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        long totalReserve = (long)gas[0] - (long)cost[0];
        int start = 0, end = (start+1)%n;
        while(true){
            while(totalReserve <= 0 && start!=end){
                totalReserve += (long)cost[start] - (long)gas[start];
                start = (start+1)%n;
            }
            if(start==end){
                totalReserve += (long)gas[start] - (long)cost[start];
                end = (start+1)%n;
            }
            while(totalReserve >= 0 && start!=end){
                totalReserve += (long)gas[end] - (long)cost[end];
                end = (end+1)%n;
            }
            if(start==end){
                break;
            }
        }
        return start;
    }
}