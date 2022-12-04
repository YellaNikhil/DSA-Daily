class Solution {
    private long findSum(int[] nums){
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            ans += nums[i];
        }
        return ans;
    }
    public int minimumAverageDifference(int[] nums) {
        long sum = findSum(nums);
        // System.out.println(sum);
        long rightSum = sum, leftSum = 0;
        int n = nums.length,ans = 0, index = 1;
        long  minDiff = rightSum;
        n--;
        for(int i=0;i<nums.length-1;i++){
            rightSum -= nums[i];
            leftSum += nums[i];
            long leftAvg = leftSum/index;
            long rightAvg = rightSum/n;
            long diff = Math.abs(leftAvg - rightAvg);
            if(diff < minDiff){
                ans = i;
                minDiff = diff;
            }
            n--;
            index++;
        }
        leftSum += nums[index-1];
        leftSum = leftSum/index;
        if(leftSum < minDiff){
            minDiff = leftSum;
            ans = index-1;
        }
        return ans;
    }
}