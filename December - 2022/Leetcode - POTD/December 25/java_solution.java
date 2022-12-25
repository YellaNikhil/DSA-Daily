class Solution {
    private int lowerBound(int[] nums, int val){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(nums[mid]>val){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return high+1;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i] = lowerBound(nums, queries[i]);
        }
        return result;
    }
}