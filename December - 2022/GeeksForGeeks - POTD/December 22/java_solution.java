class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(Long.valueOf(0), 1);
        long sum = 0;
        long count = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            else{
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum)+1);
        }
        return count;
    }
}