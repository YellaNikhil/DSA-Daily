class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums[0]==0){
            return nums.size()==1;
        }
        int maxJumps = nums[0], steps = nums[0];
        for(int i=1;i<nums.size();i++){
            if(i==nums.size()-1){
                return true;
            }
            maxJumps = max(nums[i]+i, maxJumps);
            steps--;
            if(steps==0){
                if(maxJumps <= i){
                    return false;
                }
                steps = maxJumps - i;
            }
        }
        return true;
    }
};