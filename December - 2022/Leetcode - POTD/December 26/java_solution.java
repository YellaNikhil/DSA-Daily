class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]==0){
            return nums.length==1;
        }
        int maxSteps = nums[0], steps = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1){
                return true;
            }
            maxSteps = Math.max(maxSteps, nums[i]+i);
            steps--;
            if(steps==0){
                if(maxSteps<=i){
                    return false;
                }
                steps = maxSteps - i;
            }
        }
        return true;
    }
}