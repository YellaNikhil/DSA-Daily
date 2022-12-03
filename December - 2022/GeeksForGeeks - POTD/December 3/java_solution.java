class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
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
}