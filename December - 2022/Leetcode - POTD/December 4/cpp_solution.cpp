class Solution {
public:
    long long int findSum(vector<int> &nums){
        long long int ans = 0;
        for(auto num : nums){
            ans += num;
        }
        return ans;
    }
    int minimumAverageDifference(vector<int>& nums) {
        long long int sum = findSum(nums);
        int n = nums.size(), index = 1, ans = 0;
        long long leftSum = 0, rightSum = sum;
        long long minDiff = sum;
        n--;
        for(int i=0;i<nums.size()-1;i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            int leftAvg = leftSum/index;
            int rightAvg = rightSum/n;
            int diff = abs(leftAvg - rightAvg);
            if(diff < minDiff){
                minDiff = diff;
                ans = i;
            }
            index++;
            n--;
        }
        leftSum += nums[index-1];
        leftSum = leftSum/index;
        if(leftSum < minDiff){
            ans = index - 1;
            minDiff = leftSum;
        }
        return ans;
    }
};