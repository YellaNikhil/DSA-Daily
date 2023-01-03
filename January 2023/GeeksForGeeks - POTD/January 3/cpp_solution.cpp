//User function Template for C++

class Solution {
  private:
    int findIndex(vector<int> nums, int low, int high, int val){
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] < val){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
  public:
    int removeStudents(int H[], int N) {
        // code here
        vector<int> nums;
        nums.push_back(H[0]);
        int ans =  1;
        for(int i=1;i<N;i++){
            int index = lower_bound(nums.begin(), nums.end(), H[i]) - nums.begin();
            if(index >= nums.size()){
                nums.emplace_back(H[i]);
            }
            else{
                nums[index] = H[i];
            }
        }
        return N - nums.size();
    }
};


