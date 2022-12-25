class Solution {
public:
    int lowerBound(vector<int> nums, int val){
        int low = 0, high = nums.size()-1;
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
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        sort(nums.begin(), nums.end());
        for(int i=1;i<nums.size();i++){
            nums[i] += nums[i-1];
        }
        vector<int> result(queries.size());
        for(int i=0;i<queries.size();i++){
            result[i] = lowerBound(nums, queries[i]);
        }
        return result;
    }
};

