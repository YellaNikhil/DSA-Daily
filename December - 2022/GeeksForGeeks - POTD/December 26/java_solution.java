class Solution{
    public List<Long> arr = new ArrayList<Long>();
    void precompute(){
        // Code Here
        for(int i=2;i<63;i++){
            long num1 = (long)1 << i;
            for(int j=1;j<i;j++){
                long num2 = num1 | ((long)1 << j);
                for(int k=0;k<j;k++){
                    long num3 = num2 | ((long)1 << k);
                    this.arr.add(num3);
                }
            }
        }
    }
    long findLowerBound(long x){
        int low = 0, high = this.arr.size();
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(this.arr.get(mid) >= x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    long solve(long L, long R){
        // Code here
        long left = findLowerBound(L);
        long right = findLowerBound(R);
        if(this.arr.get((int)right)!=R){
            right--;
        }
        return right - left + 1;
    }
    
}